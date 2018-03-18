#!/bin/bash

# Usage: execute.sh [WildFly mode] [configuration file]
#
# The default mode is 'standalone' and default configuration is based on the
# mode. It can be 'standalone.xml' or 'domain.xml'.

JBOSS_HOME=/opt/jboss/wildfly
JBOSS_CLI=$JBOSS_HOME/bin/jboss-cli.sh
JBOSS_MODE=${1:-"standalone"}
JBOSS_CONFIG=${2:-"$JBOSS_MODE.xml"}

function wait_for_server() {
  until `$JBOSS_CLI -c ":read-attribute(name=server-state)" 2> /dev/null | grep -q running`; do
    sleep 1
  done
}

echo "=> Starting WildFly server"
$JBOSS_HOME/bin/$JBOSS_MODE.sh -b 0.0.0.0 -c $JBOSS_CONFIG &

echo "=> Waiting for the server to boot"
wait_for_server

echo "=> Preparing server DB connection"
echo "=> MYSQL_URI: " $MYSQL_URI
echo "=> MYSQL_DATABASE: " $MYSQL_DATABASE
echo "=> MYSQL_USER: " $MYSQL_USER
echo "=> MYSQL_PASSWORD: " $MYSQL_PASSWORD
echo "=> DATASOURCE_NAME: " $DATASOURCE_NAME

$JBOSS_CLI -c << EOF
batch

#set CONNECTION_URL
set CONNECTION_URL=jdbc:mysql://$MYSQL_URI/$MYSQL_DATABASE
echo "Connection URL: " $CONNECTION_URL

# Add MySQL module
module add --name=com.mysql --resources=/opt/jboss/wildfly/config/mysql-connector-java-8.0.8-dmr.jar --dependencies=javax.api,javax.transaction.api

# Add MySQL driver
/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql,driver-xa-datasource-class-name=com.mysql.jdbc.jdbc2.optional.MysqlXADataSource)
#/subsystem=datasources/jdbc-driver=mysql:add(driver-name=mysql,driver-module-name=com.mysql,driver)

# Add the datasource
data-source add --name=ISAJeeAuth --driver-name=mysql --jndi-name=$DATASOURCE_NAME --connection-url=jdbc:mysql://$MYSQL_URI/$MYSQL_DATABASE?useUnicode=true&characterEncoding=UTF-8&useSSL=false --user-name=$MYSQL_USER --password=$MYSQL_PASSWORD --enabled=true

# Add security domain
/subsystem=security/security-domain=AutopartsSecurityDomain:add(cache-type=default)
/subsystem=security/security-domain=AutopartsSecurityDomain/authentication=classic:add(login-modules=[{"code"=>"Database","flag"=>"required","module-options"=>[("dsJndiName"=>"java:/ISAJeeAuth"),("principalsQuery"=>"SELECT password FROM user WHERE login=?"), ("rolesQuery"=>"SELECT user_role, 'Roles' FROM roles WHERE user_login=?"), ("hashAlgorithm"=>"MD5"), ("hashEncoding"=>"hex")]}])

# Execute the batch
run-batch
EOF

# Deploy the WAR
cp /opt/jboss/wildfly/config/autoparts-Jee.war $JBOSS_HOME/$JBOSS_MODE/deployments/

echo "=> Shutting down WildFly"
if [ "$JBOSS_MODE" = "standalone" ]; then
  $JBOSS_CLI -c ":shutdown"
else
  $JBOSS_CLI -c "/host=*:shutdown"
fi

echo "=> Restarting WildFly"

#add user for console management tool
/opt/jboss/wildfly/bin/add-user.sh admin admin --silent

#run wildfly
$JBOSS_HOME/bin/$JBOSS_MODE.sh -b 0.0.0.0 -bmanagement 0.0.0.0 -c $JBOSS_CONFIG


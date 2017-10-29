package pl.isa.autoparts.vehiclefinder;

public class VehicleBreadcrumbs {

    private VehicleData[] data;

    private String datatype;

    public VehicleData[] getData ()
    {
        return data;
    }

    public void setData (VehicleData[] data)
    {
        this.data = data;
    }

    public String getDatatype ()
    {
        return datatype;
    }

    public void setDatatype (String datatype)
    {
        this.datatype = datatype;
    }

    // TODO override toString()
}

//package pl.isa.autoparts.questions;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.contrib.java.lang.system.SystemOutRule;
//import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
//
//public class QuestionaryTest {
//
//    @Rule
//    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
//
//    @Rule
//    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
//
//    @Test
//    public void should_display_options_on_console() throws Exception {
//        systemInMock.provideLines("y","y","y");
//        Questionary questionary = new Questionary();
//        questionary.questionOptions();
//        assertThat(systemOutRule.getLog()).isNotEmpty();
//    }
//
//    @Test
//    public void should_display_different_options_on_console() throws Exception {
//        systemInMock.provideLines("y","n","y","y");
//        Questionary questionary = new Questionary();
//        questionary.questionOptions();
//        assertThat(systemOutRule.getLog()).isNotEmpty();
//
//        systemInMock.provideLines("y","y","n","n","y");
//        questionary.questionOptions();
//        assertThat(systemOutRule.getLog()).isNotEmpty();
//    }
//
//    @Test
//    public void should_find_intercooler_parts() throws Exception {
//        systemInMock.provideLines("y","y","n","y");
//        Questionary questionary = new Questionary();
//        questionary.questionOptions();
//        assertThat(questionary.getPartsListForLink()).contains("Przewody chłodnic wody");
////        assertThat(systemOutRule.getLog()).contains("Przewody chłodnic wody");
//    }
//}
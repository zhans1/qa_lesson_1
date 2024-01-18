package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponents {
    public static void setDate(String day, String month, String year) {
        $("select.react-datepicker__year-select").selectOptionByValue(year);
        $("select.react-datepicker__month-select").selectOptionByValue(month);
        $("div.react-datepicker__day--0" + day).click();
    }
}

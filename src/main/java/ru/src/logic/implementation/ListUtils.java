package ru.src.logic.implementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import ru.src.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {

    private static final ObservableList<String> memberStatusList = fillMemberStatusList();
    private static final ObservableList<String> organizationFormList = fillOrganizationFormList();
    private static final ObservableList<String> economicSectorList = fillEconomicSectorList();
    private static final ObservableList<String> ownershipFormList = fillOwnershipFormList();
    private static final ObservableList<String> activityTypeList = fillActivityTypeList();
    private static final ObservableList<String> businessFormList = fillBusinessFormList();
    private static final ObservableList<String> interestingList = fillInterestingList();
    private static final ObservableList<String> vedList = fillVedList();
    private static final ObservableList<String> getDedbStatusList = fillDedbStatusList();
    private static final ObservableList<String> districtList = fillDistrictList();
    private static final HashMap<Integer, String> regionMap = fillRegionMap();
    private static final HashMap<Integer, String> months = fillMonths();
    private static final ObservableList<String> findParamsList = fillFindParamsList();

    public static ObservableList<String> getMemberStatusList() {
        return memberStatusList;
    }

    public static ObservableList<String> getOrganizationForm() {
        return organizationFormList;
    }

    public static ObservableList<String> getEconomicSector() {
        return economicSectorList;
    }

    public static ObservableList<String> getOwnershipForm() {
        return ownershipFormList;
    }

    public static ObservableList<String> getActivityType() {
        return activityTypeList;
    }

    public static ObservableList<String> getBusinessForm() {
        return businessFormList;
    }

    public static ObservableList<String> getInteresting() {
        return interestingList;
    }

    public static ObservableList<String> getYesNo() {
        return vedList;
    }

    public static ObservableList<String> getDedbStatusList() {
        return getDedbStatusList;
    }

    public static ObservableList<String> getDistrict() {
        return districtList;
    }

    public static HashMap<Integer, String> getRegionMap() {
        return regionMap;
    }

    public static HashMap<Integer, String> getMonth() {
        return months;
    }

    public static ObservableList<String> getFindParamsList() {
        return findParamsList;
    }

    public static String[] getDataFromCheckBoxMassive(String title, ArrayList<CheckBox> checkBoxes) {
        String[] result = new String[2];
        List<String> selectedCheckBox = checkBoxes.stream()
                .filter(checkBox -> checkBox.isSelected())
                .map(checkBox -> checkBox.getText())
                .collect(Collectors.toList());

        if (selectedCheckBox.size() == 0) {
            return null;
        }

        result[0] = title;
        result[1] = String.join(", ", selectedCheckBox) + ".";
        return result;
    }

    public static void updateUser(ObservableList<User> users, User user) {
        int searchIndex = 0;
        for (User searchUser: users) {
            if(searchUser.getLogin().equals(user.getLogin())) {
                searchIndex = users.indexOf(searchUser);
            }
        }
        users.set(searchIndex, user);
    }

    private static ObservableList<String> fillFindParamsList() {
        ObservableList<String> result = FXCollections.observableArrayList();
        result.add("Номер билета");
        result.add("Полное название");
        result.add("Сокращенное название");
        result.add("ФИО руководителя");
        result.add("Деятельность/Услуги");
        return result;
    }

    private static ObservableList<String> fillMemberStatusList() {
        ObservableList<String> result = FXCollections.observableArrayList();
        result.add("Актуально стабильно");
        result.add("Актуально нестабильно");
        result.add("Актуально долг 1 год");
        result.add("Актуально долг 2 года");
        result.add("Актуально долг 3 года");
        result.add("Заявление на исключение");
        result.add("Деятельность прекращена");
        result.add("Потеря связи");
        result.add("Смена формы собственности");
        result.add("На исключение");
        return result;
    }

    private static ObservableList<String> fillOrganizationFormList() {
        ObservableList<String> result = FXCollections.observableArrayList();
        result.add("ООО");
        result.add("ПАО");
        result.add("АО");
        result.add("ИАО");
        result.add("ИП");
        result.add("НП");
        result.add("ОАО");
        result.add("ЗАО");
        result.add("СРО");
        result.add("ФОНД");
        result.add("Ассоциация");
        result.add("Союз");
        result.add("Объединение");
        result.add("Самозанятый");
        result.add("ОУ");
        result.add("АНО");
        result.add("Бюджетное учреждение");
        result.add("Госучреждение");
        return result;
    }

    private static ObservableList<String> fillEconomicSectorList() {
        ObservableList<String> result = FXCollections.observableArrayList();
        result.add("Торговля");
        result.add("Услуги");
        result.add("Производство");
        result.add("Сельскохозяйственная деятельность");
        result.add("Рыбный промысел");
        result.add("Лесное хозяйство");
        result.add("Строительство");
        result.add("Транспорт");
        result.add("Связь");
        result.add("Образование");
        result.add("Недвижимость");
        result.add("Бытовое обслуживание");
        result.add("Полиграфия и издательство");
        result.add("Туризм");
        result.add("Компьютерные услуги");
        result.add("Общественное питание");
        result.add("Иное");
        return result;
    }

    private static ObservableList<String> fillOwnershipFormList() {
        ObservableList<String> result = FXCollections.observableArrayList();
        result.add("Частная");
        result.add("Государственная");
        result.add("Смешанная");
        return result;
    }

    private static ObservableList<String> fillActivityTypeList() {
        ObservableList<String> result = FXCollections.observableArrayList();
        result.add("Коммерческая");
        result.add("Не коммерческая");
        return result;
    }

    private static ObservableList<String> fillBusinessFormList() {
        ObservableList<String> result = FXCollections.observableArrayList();
        result.add("Микробизнес (<15)");
        result.add("Малый бизнес (15-100)");
        result.add("Средний бизнес (101-250)");
        result.add("Крупный бизнес (>250)");
        return result;
    }

    private static ObservableList<String> fillInterestingList() {
        ObservableList<String> result = FXCollections.observableArrayList();
        result.add("Интересует");
        result.add("Не интересует");
        return result;
    }

    private static ObservableList<String> fillVedList() {
        ObservableList<String> result = FXCollections.observableArrayList();
        result.add("Да");
        result.add("Нет");
        return result;
    }

    private static ObservableList<String> fillDedbStatusList() {
        ObservableList<String> result = FXCollections.observableArrayList();
        result.add("Имеется");
        result.add("Отсутствует");
        return result;
    }

    private static ObservableList<String> fillDistrictList() {
        ObservableList<String> result = FXCollections.observableArrayList();
        result.add("Аннинский район");
        result.add("Бобровский район");
        result.add("Богучарский район");
        result.add("Борисоглебск Городской округ");
        result.add("Бутурлиновский район");
        result.add("Верхнемамонский район");
        result.add("Верхнехавский район");
        result.add("Воробьевский район");
        result.add("Воронеж Городской округ");
        result.add("Грибановский район");
        result.add("Калачеевский район");
        result.add("Каменский район");
        result.add("Кантемировский район");
        result.add("Каширский район");
        result.add("Лискинский район");
        result.add("Нижнедевицкий район");
        result.add("Нововоронеж Городской округ");
        result.add("Новоусманский район");
        result.add("Новохоперский район");
        result.add("Ольховатский район");
        result.add("Острогожский район");
        result.add("Павловский район");
        result.add("Панинский район");
        result.add("Петропавловский район");
        result.add("Поворинский район");
        result.add("Подгоренский район");
        result.add("Рамонский район");
        result.add("Репьевский район");
        result.add("Россошанский район");
        result.add("Семилукский район");
        result.add("Таловский район");
        result.add("Терновский район");
        result.add("Хохольский район");
        result.add("Эртильский район");
        return result;
    }

    private static HashMap<Integer, String> fillRegionMap() {
        HashMap<Integer, String> result = new HashMap();
        result.put(1, "Республика Адыгея");
        result.put(2, "Республика Башкортостан");
        result.put(3, "Республика Бурятия");
        result.put(4, "Республика Алтай");
        result.put(5, "Республика Дагестан");
        result.put(6, "Республика Ингушетия");
        result.put(7, "Кабардино-Балкарская Республика");
        result.put(8, "Республика Калмыкия");
        result.put(9, "Карачаево-Черкесская Республика");
        result.put(10, "Республика Карелия");
        result.put(11, "Республика Коми");
        result.put(12, "Республика Марий Эл");
        result.put(13, "Республика Мордовия");
        result.put(14, "Республика Саха (Якутия)");
        result.put(15, "Республика Северная Осетия - Алания");
        result.put(16, "Республика Татарстан (Татарстан)");
        result.put(17, "Республика Тыва");
        result.put(18, "Удмуртская Республика");
        result.put(19, "Республика Хакасия");
        result.put(20, "Чеченская Республика");
        result.put(21, "Чувашская Республика - Чувашия");
        result.put(22, "Алтайский край");
        result.put(23, "Краснодарский край");
        result.put(24, "Красноярский край");
        result.put(25, "Приморский край");
        result.put(26, "Ставропольский край");
        result.put(27, "Хабаровский край");
        result.put(28, "Амурская область");
        result.put(29, "Архангельская область");
        result.put(30, "Астраханская область");
        result.put(31, "Белгородская область");
        result.put(32, "Брянская область");
        result.put(33, "Владимирская область");
        result.put(34, "Волгоградская область");
        result.put(35, "Вологодская область");
        result.put(36, "Воронежская область");
        result.put(37, "Ивановская область");
        result.put(38, "Иркутская область");
        result.put(39, "Калининградская область");
        result.put(40, "Калужская область");
        result.put(41, "Камчатская область");
        result.put(42, "Кемеровская область");
        result.put(43, "Кировская область");
        result.put(44, "Костромская область");
        result.put(45, "Курганская область");
        result.put(46, "Курская область");
        result.put(47, "Ленинградская область");
        result.put(48, "Липецкая область");
        result.put(49, "Магаданская область");
        result.put(50, "Московская область");
        result.put(51, "Мурманская область");
        result.put(52, "Нижегородская область");
        result.put(53, "Новгородская область");
        result.put(54, "Новосибирская область");
        result.put(55, "Омская область");
        result.put(56, "Оренбургская область");
        result.put(57, "Орловская область");
        result.put(58, "Пензенская область");
        result.put(59, "Пермская область");
        result.put(60, "Псковская область");
        result.put(61, "Ростовская область");
        result.put(62, "Рязанская область");
        result.put(63, "Самарская область");
        result.put(64, "Саратовская область");
        result.put(65, "Сахалинская область");
        result.put(66, "Свердловская область");
        result.put(67, "Смоленская область");
        result.put(68, "Тамбовская область");
        result.put(69, "Тверская область");
        result.put(70, "Томская область");
        result.put(71, "Тульская область");
        result.put(72, "Тюменская область");
        result.put(73, "Ульяновская область");
        result.put(74, "Челябинская область");
        result.put(75, "Читинская область");
        result.put(76, "Ярославская область");
        result.put(77, "г. Москва");
        result.put(78, "г. Санкт-Петербург");
        result.put(79, "Еврейская автономная область");
        result.put(80, "Агинский Бурятский автономный округ");
        result.put(81, "Коми-Пермяцкий автономный округ");
        result.put(82, "Корякский автономный округ");
        result.put(83, "Ненецкий автономный округ");
        result.put(84, "Таймырский (Долгано-Ненецкий) автономный округ");
        result.put(85, "Усть-Ордынский Бурятский автономный округ");
        result.put(86, "Ханты-Мансийский автономный округ - Югра");
        result.put(87, "Чукотский автономный округ");
        result.put(89, "Ямало-Ненецкий автономный округ");
        result.put(91, "Республика Крым");
        result.put(92, "г. Севастополь");
        result.put(99, "Иные территории, включая город и космодром Байконур");
        return result;
    }

    private static HashMap<Integer, String> fillMonths() {
        HashMap<Integer, String> result = new HashMap();
        result.put(1, "Январь");
        result.put(2, "Февраль");
        result.put(3, "Март");
        result.put(4, "Апрель");
        result.put(5, "Май");
        result.put(6, "Июнь");
        result.put(7, "Июль");
        result.put(8, "Август");
        result.put(9, "Сентябрь");
        result.put(10, "Октябрь");
        result.put(11, "Ноябрь");
        result.put(12, "Декабрь");
        return result;
    }
}

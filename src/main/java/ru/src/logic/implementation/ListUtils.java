package ru.src.logic.implementation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ListUtils {
    public static ObservableList<String> getMemberStatusList() {
        ObservableList<String> memberStatusList = FXCollections.observableArrayList();
        memberStatusList.add("Актуально стабильно");
        memberStatusList.add("Актуально нестабильно");
        memberStatusList.add("Актуально долг 1 год");
        memberStatusList.add("Актуально долг 2 года");
        memberStatusList.add("Актуально долг 3 года");
        memberStatusList.add("Заявление на исключение");
        memberStatusList.add("Деятельность прекращена");
        memberStatusList.add("Потеря связи");
        memberStatusList.add("Смена формы собственности");
        memberStatusList.add("На исключение");
        return memberStatusList;
    }

    public static ObservableList<String> getOrganizationForm() {
        ObservableList<String> organizationFormList = FXCollections.observableArrayList();
        organizationFormList.add("ООО");//
        organizationFormList.add("ПАО");//
        organizationFormList.add("АО");//
        organizationFormList.add("ИАО");//
        organizationFormList.add("ИП");//
        organizationFormList.add("НП");//
        organizationFormList.add("ОАО");//
        organizationFormList.add("ЗАО");//
        organizationFormList.add("СРО");//
        organizationFormList.add("ФОНД");//
        organizationFormList.add("Ассоциация");//
        organizationFormList.add("Союз");//
        organizationFormList.add("Объединение");//
        organizationFormList.add("Самозанятый");//
        organizationFormList.add("ОУ");//
        organizationFormList.add("АНО");//
        organizationFormList.add("Бюджетное учреждение");//
        organizationFormList.add("Госучреждение");//
        return organizationFormList;
    }
    public static ObservableList<String> getEconomicSector() {
        ObservableList<String> economicSectorList = FXCollections.observableArrayList();
        economicSectorList.add("Торговля");
        economicSectorList.add("Услуги");
        economicSectorList.add("Производство");
        economicSectorList.add("Сельскохозяйственная деятельность");
        economicSectorList.add("Рыбный промысел");
        economicSectorList.add("Лесное хозяйство");
        economicSectorList.add("Строительство");
        economicSectorList.add("Транспорт");
        economicSectorList.add("Связь");
        economicSectorList.add("Образование");
        economicSectorList.add("Недвижимость");
        economicSectorList.add("Бытовое обслуживание");
        economicSectorList.add("Полиграфия и издательство");
        economicSectorList.add("Туризм");
        economicSectorList.add("Компьютерные услуги");
        economicSectorList.add("Общественное питание");
        return economicSectorList;
    }
    public static ObservableList<String> getOwnershipForm() {
        ObservableList<String> ownershipFormList = FXCollections.observableArrayList();
        ownershipFormList.add("Частная");
        ownershipFormList.add("Государственная");
        ownershipFormList.add("Смешанная");
        return ownershipFormList;
    }
    public static ObservableList<String> getActivityType() {
        ObservableList<String> activityTypeList = FXCollections.observableArrayList();
        activityTypeList.add("Коммерческая");
        activityTypeList.add("Не коммерческая");
        return activityTypeList;
    }
    public static ObservableList<String> getBusinessForm() {
        ObservableList<String> businessFormList = FXCollections.observableArrayList();
        businessFormList.add("Микробизнес ( <15 )");
        businessFormList.add("Малый бизнес (15 - 100)");
        businessFormList.add("Средний бизнес (101 - 250)");
        businessFormList.add("Крупный бизнес ( >250 )");
        return businessFormList;
    }
    public static ObservableList<String> getInteresting() {
        ObservableList<String> interestingList = FXCollections.observableArrayList();
        interestingList.add("Интересует");
        interestingList.add("Не интересует");
        return interestingList;
    }
    public static ObservableList<String> getYesNo() {
        ObservableList<String> vedList = FXCollections.observableArrayList();
        vedList.add("Да");
        vedList.add("Нет");
        return vedList;

    }
    public static ObservableList<String> getDedbStatusList() {
        ObservableList<String> getDedbStatusList = FXCollections.observableArrayList();
        getDedbStatusList.add("Имеется");
        getDedbStatusList.add("Отсутствует");
        return getDedbStatusList;
    }
    public static ObservableList<String> getDistrict() {
        ObservableList<String> districtList = FXCollections.observableArrayList();
        districtList.add("Аннинский район");
        districtList.add("Бобровский район");
        districtList.add("Богучарский район");
        districtList.add("Борисоглебск Городской округ");
        districtList.add("Бутурлиновский район");
        districtList.add("Верхнемамонский район");
        districtList.add("Верхнехавский район");
        districtList.add("Воробьевский район");
        districtList.add("Воронеж Городской округ");
        districtList.add("Грибановский район");
        districtList.add("Калачеевский район");
        districtList.add("Каменский район");
        districtList.add("Кантемировский район");
        districtList.add("Каширский район");
        districtList.add("Лискинский район");
        districtList.add("Нижнедевицкий район");
        districtList.add("Нововоронеж Городской округ");
        districtList.add("Новоусманский район");
        districtList.add("Новохоперский район");
        districtList.add("Ольховатский район");
        districtList.add("Острогожский район");
        districtList.add("Павловский район");
        districtList.add("Панинский район");
        districtList.add("Петропавловский район");
        districtList.add("Поворинский район");
        districtList.add("Подгоренский район");
        districtList.add("Рамонский район");
        districtList.add("Репьевский район");
        districtList.add("Россошанский район");
        districtList.add("Семилукский район");
        districtList.add("Таловский район");
        districtList.add("Терновский район");
        districtList.add("Хохольский район");
        districtList.add("Эртильский район");
        return districtList;
    }
    public static HashMap<Integer, String> getRegionMap() {
        HashMap<Integer, String> regionMap = new HashMap<>();
        regionMap.put(1, "Республика Адыгея");
        regionMap.put(2, "Республика Башкортостан");
        regionMap.put(3, "Республика Бурятия");
        regionMap.put(4, "Республика Алтай");
        regionMap.put(5, "Республика Дагестан");
        regionMap.put(6, "Республика Ингушетия");
        regionMap.put(7, "Кабардино-Балкарская Республика");
        regionMap.put(8, "Республика Калмыкия");
        regionMap.put(9, "Карачаево-Черкесская Республика");
        regionMap.put(10, "Республика Карелия");
        regionMap.put(11, "Республика Коми");
        regionMap.put(12, "Республика Марий Эл");
        regionMap.put(13, "Республика Мордовия");
        regionMap.put(14, "Республика Саха (Якутия)");
        regionMap.put(15, "Республика Северная Осетия - Алания");
        regionMap.put(16, "Республика Татарстан (Татарстан)");
        regionMap.put(17, "Республика Тыва");
        regionMap.put(18, "Удмуртская Республика");
        regionMap.put(19, "Республика Хакасия");
        regionMap.put(20, "Чеченская Республика");
        regionMap.put(21, "Чувашская Республика - Чувашия");
        regionMap.put(22, "Алтайский край");
        regionMap.put(23, "Краснодарский край");
        regionMap.put(24, "Красноярский край");
        regionMap.put(25, "Приморский край");
        regionMap.put(26, "Ставропольский край");
        regionMap.put(27, "Хабаровский край");
        regionMap.put(28, "Амурская область");
        regionMap.put(29, "Архангельская область");
        regionMap.put(30, "Астраханская область");
        regionMap.put(31, "Белгородская область");
        regionMap.put(32, "Брянская область");
        regionMap.put(33, "Владимирская область");
        regionMap.put(34, "Волгоградская область");
        regionMap.put(35, "Вологодская область");
        regionMap.put(36, "Воронежская область");
        regionMap.put(37, "Ивановская область");
        regionMap.put(38, "Иркутская область");
        regionMap.put(39, "Калининградская область");
        regionMap.put(40, "Калужская область");
        regionMap.put(41, "Камчатская область");
        regionMap.put(42, "Кемеровская область");
        regionMap.put(43, "Кировская область");
        regionMap.put(44, "Костромская область");
        regionMap.put(45, "Курганская область");
        regionMap.put(46, "Курская область");
        regionMap.put(47, "Ленинградская область");
        regionMap.put(48, "Липецкая область");
        regionMap.put(49, "Магаданская область");
        regionMap.put(50, "Московская область");
        regionMap.put(51, "Мурманская область");
        regionMap.put(52, "Нижегородская область");
        regionMap.put(53, "Новгородская область");
        regionMap.put(54, "Новосибирская область");
        regionMap.put(55, "Омская область");
        regionMap.put(56, "Оренбургская область");
        regionMap.put(57, "Орловская область");
        regionMap.put(58, "Пензенская область");
        regionMap.put(59, "Пермская область");
        regionMap.put(60, "Псковская область");
        regionMap.put(61, "Ростовская область");
        regionMap.put(62, "Рязанская область");
        regionMap.put(63, "Самарская область");
        regionMap.put(64, "Саратовская область");
        regionMap.put(65, "Сахалинская область");
        regionMap.put(66, "Свердловская область");
        regionMap.put(67, "Смоленская область");
        regionMap.put(68, "Тамбовская область");
        regionMap.put(69, "Тверская область");
        regionMap.put(70, "Томская область");
        regionMap.put(71, "Тульская область");
        regionMap.put(72, "Тюменская область");
        regionMap.put(73, "Ульяновская область");
        regionMap.put(74, "Челябинская область");
        regionMap.put(75, "Читинская область");
        regionMap.put(76, "Ярославская область");
        regionMap.put(77, "г. Москва");
        regionMap.put(78, "г. Санкт-Петербург");
        regionMap.put(79, "Еврейская автономная область");
        regionMap.put(80, "Агинский Бурятский автономный округ");
        regionMap.put(81, "Коми-Пермяцкий автономный округ");
        regionMap.put(82, "Корякский автономный округ");
        regionMap.put(83, "Ненецкий автономный округ");
        regionMap.put(84, "Таймырский (Долгано-Ненецкий) автономный округ");
        regionMap.put(85, "Усть-Ордынский Бурятский автономный округ");
        regionMap.put(86, "Ханты-Мансийский автономный округ - Югра");
        regionMap.put(87, "Чукотский автономный округ");
        regionMap.put(89, "Ямало-Ненецкий автономный округ");
        regionMap.put(91, "Республика Крым");
        regionMap.put(92, "г. Севастополь");
        regionMap.put(99, "Иные территории, включая город и космодром Байконур");
        return regionMap;
    }
    public static HashMap<Integer, String> getMonth() {
        HashMap<Integer, String> month = new HashMap<Integer, String>();
        month.put(1, "Январь");
        month.put(2, "Февраль");
        month.put(3, "Март");
        month.put(4, "Апрель");
        month.put(5, "Май");
        month.put(6, "Июнь");
        month.put(7, "Июль");
        month.put(8, "Август");
        month.put(9, "Сентябрь");
        month.put(10, "Октябрь");
        month.put(11, "Ноябрь");
        month.put(12, "Декабрь");
        return month;
    }
    public static String[] getDataFromCheckBoxMassive(String title, ArrayList<CheckBox> checkBoxes) {
        String[] result = new String[2];
        ArrayList<String> selectedCheckBox = new ArrayList<String>();
        for (CheckBox box : checkBoxes) {
            if (box.isSelected()) {
                selectedCheckBox.add(box.getText());
            }
        }

        if (selectedCheckBox.size() == 0) return null;
        else {
            result[0] = title;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < selectedCheckBox.size(); i++) {
                if (i != selectedCheckBox.size() - 1) {
                    stringBuilder.append(selectedCheckBox.get(i)).append(", ");
                } else stringBuilder.append(selectedCheckBox.get(i)).append(".");
            }
            result[1] = stringBuilder.toString();
            return result;
        }
    }



    public static void removeAllNullObjectFromList(ArrayList list) {
        int index = list.lastIndexOf(null);
        if(index != -1) {
            list.remove(null);
            removeAllNullObjectFromList(list);
        }
    }
}

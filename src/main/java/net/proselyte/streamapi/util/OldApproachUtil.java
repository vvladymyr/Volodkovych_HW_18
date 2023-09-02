package net.proselyte.streamapi.util;

import net.proselyte.streamapi.model.Specialist;
import net.proselyte.streamapi.model.Specialty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OldApproachUtil {
    // Створення початкового списка спеціалістів
    public static List<Specialist> getSpecialists() {
        List<Specialist> result = new ArrayList<>();
        result.add(new Specialist("Ivan Ivanenko", new BigDecimal(5000), Specialty.ENGINEER));
        result.add(new Specialist("Olexander Panenko", new BigDecimal(4000), Specialty.ENGINEER));
        result.add(new Specialist("Serhii Serhiienko", new BigDecimal(3000), Specialty.DEVOPS));
        result.add(new Specialist("Fedir Fedorenko", new BigDecimal(2000), Specialty.DEVOPS));
        result.add(new Specialist("Kyrylo Kyrylenko", new BigDecimal(10000), Specialty.MANAGER));
        result.add(new Specialist("Petro Petrenko", new BigDecimal(10000), Specialty.MANAGER));

        return result;
    }

    // Пошук за спеціальністю
    public static List<Specialist> filterBySpecialty(List<Specialist> specialists, Specialty specialty) {
        List<Specialist> result = new ArrayList<>();
        for (int i = 0; i < specialists.size(); i++) {
            if (specialists.get(i).getSpecialty().equals(specialty)) {
                result.add(specialists.get(i));
            }
        }
        return result;
    }

    // Перевірка збігів усі інженери
    public static boolean matchAllEngineers(List<Specialist> specialists) {
        for (int i = 0; i < specialists.size(); i++) {
            if (!specialists.get(i).getSpecialty().equals(Specialty.ENGINEER)) {
                return false;
            }
        }
        return true;
    }

    // Перевірка збігів - чи є інженери
    public static boolean matchAnyEnginner(List<Specialist> specialists) {
        for (int i = 0; i < specialists.size(); i++) {
            if (specialists.get(i).getSpecialty().equals(Specialty.ENGINEER)) {
                return true;
            }
        }
        return false;
    }

    // Перевірка збігів - чи мають ЗП вище зазначеної
    public static boolean matchAllSalaryMoreThen(List<Specialist> specialists, BigDecimal salary) {
        for (int i = 0; i < specialists.size(); i++) {
            if (specialists.get(i).getSalary().compareTo(salary) < 0) {
                return false;
            }
        }
        return true;
    }

    // Перевірка збігів - ніхто не має ЗП вище вказаної
    public static boolean matchNoneSalaryMoreThen(List<Specialist> specialists, BigDecimal salary) {
        for (int i = 0; i < specialists.size(); i++) {
            if (specialists.get(i).getSalary().compareTo(salary) > 0) {
                return false;
            }
        }
        return true;
    }

    // Виведення в консоль
    public static void printSpecialists(List<Specialist> specialists) {
        specialists.forEach(System.out::println);
    }

    // Груповання спеціалістів за фахом
    public static Map<Specialty, List<Specialist>> groupBySpecialty(List<Specialist> specialists) {
        Map<Specialty, List<Specialist>> result = new HashMap<>();
        Specialty[] specialties = Specialty.class.getEnumConstants();
        for (int i = 0; i < specialties.length; i++) {
            result.put(specialties[i], new ArrayList<>());
        }

        /// ... many many many redundant code ...

        return result;
    }
}

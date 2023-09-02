package net.proselyte.streamapi.util;

import net.proselyte.streamapi.model.Specialist;
import net.proselyte.streamapi.model.Specialty;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamAPIUtil {
    // Створення початкового списка спеціалістів
    public static List<Specialist> getSpecialists() {
        return List.of(
                new Specialist("Ivan Ivanenko", new BigDecimal(5000), Specialty.ENGINEER),
                new Specialist("Olexander Panenko", new BigDecimal(4000), Specialty.ENGINEER),
                new Specialist("Serhii Serhiienko", new BigDecimal(3000), Specialty.DEVOPS),
                new Specialist("Fedir Fedorenko", new BigDecimal(2000), Specialty.DEVOPS),
                new Specialist("Kyrylo Kyrylenko", new BigDecimal(10000), Specialty.MANAGER),
                new Specialist("Petro Petrenko", new BigDecimal(10000), Specialty.MANAGER)
        );
    }

    // Пошук за спеціальністю
    public static List<Specialist> filterBySpecialty(List<Specialist> specialists, Specialty specialty) {
        return specialists.stream()
                .filter(specialist -> specialist.getSpecialty().equals(specialty))
                .collect(Collectors.toList());
    }

    // Сортування за ім'ям за зростанням
    public static List<Specialist> sortSpecialistsByNameAsc(List<Specialist> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(Specialist::getName))
//                .sorted(Comparator.comparing(specialist -> specialist.getName()))
                .collect(Collectors.toList());
    }

    // Сортування по імені за спаданням
    public static List<Specialist> sortSpecialistsByNameDesc(List<Specialist> specialists) {
        return specialists.stream()
                .sorted(Comparator.comparing(Specialist::getName).reversed())
                .collect(Collectors.toList());
    }

    // Перевірка збігів чи усі інженери
    public static boolean matchAllEngineers(List<Specialist> specialists) {
        return specialists.stream().allMatch(specialist -> specialist.getSpecialty().equals(Specialty.ENGINEER));
    }

    // Перевірка збігів - чи є інженери
    public static boolean matchAnyEngineer(List<Specialist> specialists) {
        return specialists.stream().anyMatch(specialist -> specialist.getSpecialty().equals(Specialty.ENGINEER));
    }

    // Перевірка збігів - чи мають ЗП вище зазначеної
    public static boolean matchAllSalaryMoreThen(List<Specialist> specialists, BigDecimal salary) {
        return specialists.stream().allMatch(specialist -> specialist.getSalary().compareTo(salary) > 0);
    }

    // Перевірка збігів - ніхто не має ЗП вище вказаної
    public static boolean matchNoneSalaryMoreThen(List<Specialist> specialists, BigDecimal salary) {
        return specialists.stream().noneMatch(specialist -> specialist.getSalary().compareTo(salary) > 0);
    }

    // Виведення в консоль
    public static void printSpecialists(List<Specialist> specialists) {
        specialists.forEach(System.out::println);
    }

    // Пошук спеціаліста з максимальною ЗП
    public static Specialist findWithMaxSalary(List<Specialist> specialists) {
        return specialists.stream().max(Comparator.comparing(Specialist::getSalary)).orElse(null);
    }

    // Пошук спеціаліста з мінімальною ЗП
    public static Specialist findWithMinSalary(List<Specialist> specialists) {
        return specialists.stream().min(Comparator.comparing(Specialist::getSalary)).orElse(null);
    }

    // Груповання спеціалістів за фахом
    public static Map<Specialty, List<Specialist>> groupBySpecialty(List<Specialist> specialists) {
        return specialists.stream().collect(Collectors.groupingBy(Specialist::getSpecialty));
    }
}

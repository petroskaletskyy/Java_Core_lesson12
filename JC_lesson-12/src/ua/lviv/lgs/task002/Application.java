/*
 * LOGOS IT ACADEMY
 */
package ua.lviv.lgs.task002;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ua.lviv.lgs.task002.Month;
import ua.lviv.lgs.task002.Seasons;

public class Application {

	public static void main(String[] args) {

		List<Month> masMonths = Arrays.asList(Month.values()); 
		List<Seasons> masSeasons = Arrays.asList(Seasons.values());
		
		Scanner sc = new Scanner(System.in);
		

		while (true) {
			menu();

			switch (sc.next()) {
			case "1": {
				System.out.println("Введіть місяць: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = isMonthPresent(masMonths, month);

				if (!flag) {
					System.out.println("Такого місяця не існує...");
				}
				break;
			}
			case "2": {
				System.out.println("Введіть пору року:");
				sc = new Scanner(System.in);
				String season = sc.next().toUpperCase();

				boolean flag = isMonthSeasonPresent(masMonths, season);

				if (!flag) {
					System.out.println("Такої пори року не існує...");
				}
				break;
			}
			case "3": {
				System.out.println("Введіть кількість днів");
				sc = new Scanner(System.in);
				int days = sc.nextInt();

				boolean flag = isDaysPreset(masMonths, days);

				if (!flag) {
					System.out.println("Не вірно введені дані...");
				}
				break;
			}
			case "4": {
				System.out.println("Введіть кількість днів");
				sc = new Scanner(System.in);
				int days = sc.nextInt();

				boolean flag = isDaysLess(masMonths, days);

				if (!flag) {
					System.out.println("Н жаль, місяців, в яких менше днів, ніж введене число - не існує");
				}
				break;
			}
			case "5": {
				System.out.println("Введіть кількість днів");
				sc = new Scanner(System.in);
				int days = sc.nextInt();

				boolean flag = isDaysOver(masMonths, days);

				if (!flag) {
					System.out.println("Н жаль, місяців, в яких більше днів, ніж введене число - не існує");
				}
				break;
			}
			case "6": {
				System.out.println("Введіть пору року:");
				sc = new Scanner(System.in);
				String season = sc.next().toUpperCase();

				boolean flag = isSeasonPresent(masSeasons, season);

				if (flag) {
					
					int ordinal = 0;
					for (Seasons s: masSeasons) {
						if (s.name().equals(season)) {
							ordinal = s.ordinal();
						}
					}
					
					if (ordinal == masSeasons.size() - 1) {
						ordinal = 0;
						System.out.println(masSeasons.get(ordinal));
					} else {
						System.out.println(masSeasons.get(ordinal + 1));
					}
				}

				if (!flag) {
					System.out.println("Такої пори року не існує");
				}
				break;
			}
			case "7": {
				System.out.println("Введіть пору року:");
				sc = new Scanner(System.in);
				String season = sc.next().toUpperCase();

				boolean flag = isSeasonPresent(masSeasons, season);

				if (flag) {
					
					int ordinal = 0;
					for (Seasons s: masSeasons) {
						if (s.name().equals(season)) {
							ordinal = s.ordinal();
						}
					}

					if (ordinal == 0) {
						ordinal = (masSeasons.size() - 1);
						System.out.println(masSeasons.get(ordinal));
					} else {
						System.out.println(masSeasons.get(ordinal - 1));
					}
				}

				if (!flag) {
					System.out.println("Такої пори року не існує");
				}
				break;
			}
			case "8": {
				allMonthEvenDays(masMonths);
				break;
			}
			case "9": {
				allMonthOddDays(masMonths);
				break;
			}
			case "10": {
				System.out.println("Введіть місяць: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = isMonthPresent(masMonths, month);

				if (flag) {
					for (Month m : masMonths) {
						if (m.name().equals(month)) {
							if (m.getDay() % 2 == 0) {
								System.out.println("Місяць має парну кількість днів");
							} else {
								System.out.println("Місяць має непарну кількість днів");
							}
						}
					}
				}

				if (!flag) {
					System.out.println("Такого місяця не існує...");
				}
				break;
			}
			}
		}

	}

//	
//Виводить всі місяці, які мають непарну кількість днів	
//	
	/**
	 * @param List masMonth;
	 * */
	private static void allMonthOddDays(List<Month> masMonths) {
		for (Month m : masMonths) {
			if (m.getDay() % 2 != 0) {
				System.out.println(m.name());
			}
		}
	}

//	
//Виводить всі місяці, які мають парну кількість днів	
//	
	/**
	 * @param List masMonth;
	 * */
	private static void allMonthEvenDays(List<Month> masMonths) {
		for (Month m : masMonths) {
			if (m.getDay() % 2 == 0) {
				System.out.println(m.name());
			}
		}
	}

//
//Перевірка, чи існує введена пора року	
//	
	/**
	 * @param List masSeason;
	 * @param String season;
	 * @return boolean;
	 * */
	private static boolean isSeasonPresent(List<Seasons> masSeasons, String season) {
		boolean flag = false;
		for (Seasons s : masSeasons) {
			if (s.name().equals(season)) {
				System.out.println("Така пора року існує");
				flag = true;
			}
		}
		return flag;
	}

//
//Перевірка, чи існують місяці, з більшою кількістю днів, ніж введене число
//	
	/**
	 * @param List masMonth;
	 * @param int days;
	 * @return boolean;
	 * */
	private static boolean isDaysOver(List<Month> masMonths, int days) {
		boolean flag = false;
		for (Month m : masMonths) {
			if (m.getDay() > days) {
				System.out.println(m.name());
				flag = true;
			}
		}
		return flag;
	}

//
//Перевірка, чи існують місяці, з меншою кількістю днів, ніж введене число
//	
	/**
	 * @param List masMonth;
	 * @param int days;
	 * @return boolean;
	 * */
	private static boolean isDaysLess(List<Month> masMonths, int days) {
		boolean flag = false;
		for (Month m : masMonths) {
			if (m.getDay() < days) {
				System.out.println(m.name());
				flag = true;
			}
		}
		return flag;
	}

//	
//Перевірка, чи існують місяці з введеною кількість днів
//
	/**
	 * @param List masMonth;
	 * @param int days;
	 * @return boolean;
	 * */
	private static boolean isDaysPreset(List<Month> masMonths, int days) {
		boolean flag = false;

		for (Month m : masMonths) {
			if (m.getDay() == days) {
				System.out.println(m.name());
				flag = true;
			}
		}
		return flag;
	}

//
//Перевірка, чи існують місяці з введеною порою року
//	
	/**
	 * @param List masMonth;
	 * @param String season;
	 * @return boolean;
	 * */
	private static boolean isMonthSeasonPresent(List<Month> masMonths, String season) {
		boolean flag = false;

		for (Month m : masMonths) {
			if (m.getSeasons().name().equals(season)) {
				System.out.println(m.name());
				flag = true;
			}
		}
		return flag;
	}

//
//Перевірка, чи існує введений місяць
//	
	/**
	 * @param List masMonth;
	 * @param String month;
	 * @return boolean;
	 * */
	private static boolean isMonthPresent(List<Month> masMonths, String month) {
		boolean flag = false;

		for (Month m : masMonths) {
			if (m.name().equals(month)) {
				System.out.println("Такий місяць існує");
				flag = true;
			}
		}
		return flag;
	}

	static void menu() {
		System.out.println("Натисніть 1, щоб перевірити чи існує місяць:");
		System.out.println("Натисніть 2, щоб вивести всі місяці з такою порою року:");
		System.out.println("Натисніть 3, щоб вивести всі місяці з введеною кількістю днів:");
		System.out.println("Натисніть 4, щоб вивести всі місяці з меншою кількістю днів:");
		System.out.println("Натисніть 5, щоб вивести всі місяці з більшою кількістю днів:");
		System.out.println("Натисніть 6, щоб вивести наступну пору року:");
		System.out.println("Натисніть 7, щоб вивести попередню пору року:");
		System.out.println("Натисніть 8, щоб вивести всі місяці, які мають парну кількість днів");
		System.out.println("Натисніть 9, щоб вивести всі місяці, які мають непарну кількість днів");
		System.out.println("Натисніть 10, щоб перевірити, чи має місяць парну кількість днів");
	}

}

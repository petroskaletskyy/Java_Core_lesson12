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
				System.out.println("������ �����: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = isMonthPresent(masMonths, month);

				if (!flag) {
					System.out.println("������ ����� �� ����...");
				}
				break;
			}
			case "2": {
				System.out.println("������ ���� ����:");
				sc = new Scanner(System.in);
				String season = sc.next().toUpperCase();

				boolean flag = isMonthSeasonPresent(masMonths, season);

				if (!flag) {
					System.out.println("���� ���� ���� �� ����...");
				}
				break;
			}
			case "3": {
				System.out.println("������ ������� ���");
				sc = new Scanner(System.in);
				int days = sc.nextInt();

				boolean flag = isDaysPreset(masMonths, days);

				if (!flag) {
					System.out.println("�� ���� ������ ���...");
				}
				break;
			}
			case "4": {
				System.out.println("������ ������� ���");
				sc = new Scanner(System.in);
				int days = sc.nextInt();

				boolean flag = isDaysLess(masMonths, days);

				if (!flag) {
					System.out.println("� ����, ������, � ���� ����� ���, �� ������� ����� - �� ����");
				}
				break;
			}
			case "5": {
				System.out.println("������ ������� ���");
				sc = new Scanner(System.in);
				int days = sc.nextInt();

				boolean flag = isDaysOver(masMonths, days);

				if (!flag) {
					System.out.println("� ����, ������, � ���� ����� ���, �� ������� ����� - �� ����");
				}
				break;
			}
			case "6": {
				System.out.println("������ ���� ����:");
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
					System.out.println("���� ���� ���� �� ����");
				}
				break;
			}
			case "7": {
				System.out.println("������ ���� ����:");
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
					System.out.println("���� ���� ���� �� ����");
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
				System.out.println("������ �����: ");
				sc = new Scanner(System.in);
				String month = sc.next().toUpperCase();

				boolean flag = isMonthPresent(masMonths, month);

				if (flag) {
					for (Month m : masMonths) {
						if (m.name().equals(month)) {
							if (m.getDay() % 2 == 0) {
								System.out.println("̳���� �� ����� ������� ���");
							} else {
								System.out.println("̳���� �� ������� ������� ���");
							}
						}
					}
				}

				if (!flag) {
					System.out.println("������ ����� �� ����...");
				}
				break;
			}
			}
		}

	}

//	
//�������� �� �����, �� ����� ������� ������� ���	
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
//�������� �� �����, �� ����� ����� ������� ���	
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
//��������, �� ���� ������� ���� ����	
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
				System.out.println("���� ���� ���� ����");
				flag = true;
			}
		}
		return flag;
	}

//
//��������, �� ������� �����, � ������ ������� ���, �� ������� �����
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
//��������, �� ������� �����, � ������ ������� ���, �� ������� �����
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
//��������, �� ������� ����� � �������� ������� ���
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
//��������, �� ������� ����� � �������� ����� ����
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
//��������, �� ���� �������� �����
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
				System.out.println("����� ����� ����");
				flag = true;
			}
		}
		return flag;
	}

	static void menu() {
		System.out.println("�������� 1, ��� ��������� �� ���� �����:");
		System.out.println("�������� 2, ��� ������� �� ����� � ����� ����� ����:");
		System.out.println("�������� 3, ��� ������� �� ����� � �������� ������� ���:");
		System.out.println("�������� 4, ��� ������� �� ����� � ������ ������� ���:");
		System.out.println("�������� 5, ��� ������� �� ����� � ������ ������� ���:");
		System.out.println("�������� 6, ��� ������� �������� ���� ����:");
		System.out.println("�������� 7, ��� ������� ��������� ���� ����:");
		System.out.println("�������� 8, ��� ������� �� �����, �� ����� ����� ������� ���");
		System.out.println("�������� 9, ��� ������� �� �����, �� ����� ������� ������� ���");
		System.out.println("�������� 10, ��� ���������, �� �� ����� ����� ������� ���");
	}

}

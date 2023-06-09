package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < n; i++) {

			System.out.println("\nDigite os dados do " + (i + 1) + "o contribuinte:");
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();

			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();

			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();

			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();

			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();

			list.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));

		}

		for (TaxPayer obj : list) {
			System.out.println("\nResumo do " + (list.indexOf(obj) + 1) + "o contribuinte:");
			System.out.printf("Imposto bruto total: %.2f\n", obj.grossTax());
			System.out.printf("Abatimento: %.2f\n", obj.taxRebate());
			System.out.printf("Imposto devido: %.2f\n", obj.netTax());
		}

		sc.close();

	}

}

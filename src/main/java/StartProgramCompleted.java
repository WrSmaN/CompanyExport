

import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgramCompleted {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a company: ");
			String company = in.nextLine();
			System.out.print("Enter an export: ");
			String export = in.nextLine();
			ListItem toAdd = new ListItem(company, export);
			lih.insertItem(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the company to delete: ");
			String company = in.nextLine();
			System.out.print("Enter the export to delete: ");
			String export = in.nextLine();
			ListItem toDelete = new ListItem(company, export);
			lih.deleteItem(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Company");
			System.out.println("2 : Search by Export");
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the company name: ");
				String companyName = in.nextLine();
				foundItems = lih.searchForItemByStore(companyName);
			} else {
				System.out.print("Enter the item: ");
				String exportName = in.nextLine();
				foundItems = lih.searchForItemByItem(exportName);


			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getExport() + " from " + toEdit.getCompany());
				System.out.println("1 : Update Company");
				System.out.println("2 : Update Export");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Company: ");
					String newCompany = in.nextLine();
					toEdit.setCompany(newCompany);
				} else if (update == 2) {
					System.out.print("New Export: ");
					String newExport = in.nextLine();
					toEdit.setExport(newExport);
				}

				lih.updateItem(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an item");
				System.out.println("*  2 -- Edit an item");
				System.out.println("*  3 -- Delete an item");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<ListItem> allItems = lih.showAllItems();
			for(ListItem singleItem: allItems) {
				System.out.println(singleItem.returnItemDetails());
			}

		}

	}

    package com.example.todolist.Model;

    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import java.io.BufferedReader;
    import java.io.BufferedWriter;
    import java.io.IOException;
    import java.nio.file.Files;
    import java.nio.file.Path;
    import java.nio.file.Paths;
    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;
    import java.util.Iterator;

    public class ItemList {
        private static ItemList instance = new ItemList();
        private static String filename = "TodoListItems.txt";

        private ObservableList<Item> Items;
        private DateTimeFormatter formatter;

        public static ItemList getInstance() {
            return instance;
        }

        private ItemList() {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        }

        public ObservableList<Item> getItems() {
            return Items;
        }

        public void addItem(Item item) {
            Items.add(item);
        }

        public void loadItems() throws IOException {
            Items = FXCollections.observableArrayList();
            Path path = Paths.get(filename);
            String input;

            try (BufferedReader br = Files.newBufferedReader(path)){
                while ((input = br.readLine()) != null) {
                    String[] itemPieces = input.split("\t");
                    String shortDescription = itemPieces[0];
                    String details = itemPieces[1];
                    String category = itemPieces[2];
                    String dateString = itemPieces[3];

                    LocalDate date = LocalDate.parse(dateString, formatter);
                    Item OtherItem = new Item(shortDescription, details, category, date);
                    Items.add(OtherItem);
                }
            }
        }

        public void storeItems() throws IOException {
            Path path = Paths.get(filename);

            try(BufferedWriter bw = Files.newBufferedWriter(path)) {
                Iterator<Item> iter = Items.iterator();
                while (iter.hasNext()) {
                    Item item = iter.next();
                    bw.write(String.format("%s\t%S\t%s\t%s",
                            item.getShortDescription(),
                            item.getDetails(),
                            item.getCategory(),
                            item.getDeadline().format(formatter)));
                    bw.newLine();
                }
            }
        }
    }
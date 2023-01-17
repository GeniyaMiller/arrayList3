package com.skypro.arraylist.arrayList;

public interface StringList {

        public String add(String item);

        public String add(int index, String item);

        public String set(int index, String item);

        public String remove(String item);

        // Удаление элемента по индексу.
        // Вернуть удаленный элемент
        // или исключение, если подобный
        // элемент отсутствует в списке.
        public String remove(int index);

        // Проверка на существование элемента.
        // Вернуть true/false;
        public boolean contains(String item);

        public int indexOf(String item);

        public int lastIndexOf(String item);

        public String get(int index);

        public boolean equals(StringList otherList);

        public int size();

        public boolean isEmpty();


        public void clear();

        public String[] toArray();

}

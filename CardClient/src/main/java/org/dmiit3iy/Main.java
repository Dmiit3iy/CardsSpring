package org.dmiit3iy;

import org.dmiit3iy.model.Card;
import org.dmiit3iy.model.Category;
import org.dmiit3iy.model.User;
import org.dmiit3iy.retrofit.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        //Создаем новых пользователей
        /*User user = new User("user1","123","Иванов Иван Иванович");
        User user1 = new User("user2","123","Петров Петр Петрович");
        User user2 = new User("user3","123","Олегов Олег Олегович");
        */

        //добавляем пользователей
        /*try {
            userRepository.post(user);
            userRepository.post(user1);
            userRepository.post(user2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */

        //получить всех пользователей
         /* try {
            List<User> listUsers=userRepository.get();
            System.out.println(listUsers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */

        //получить пользователя по логину и паролю
        /*
        try {
            User findUser1 = userRepository.get("user1", "123");
            System.out.println(findUser1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
         */

        //получить пользователя по id
        /*
        try {
            User findUser2 = userRepository.get(2);
            System.out.println(findUser2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */

        //Удалить пользователя
        /*
        try {
            System.out.println("Пользователь: " + userRepository.delete(3) + " удален");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
/////////////////////////////////////////////////////////////////////////////////
//Создаем новые категории
        CategoryRepository categoryRepository = new CategoryRepository();
        Category category1 = new Category("Напитки");
        Category category2 = new Category("Еда");
        Category category3 = new Category("Музыка");

        //Добавляем новые категории
        /*
        try {
            categoryRepository.post(1,category1);
            categoryRepository.post(2,category1);
            categoryRepository.post(1,category3);
            categoryRepository.post(2, category2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
      */
//Получить все категории
       /* try {
            System.out.println(categoryRepository.getAll());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //Получить категорию по id
      /* try {
            System.out.println(categoryRepository.getByCategoryId(4));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //получить категорию по id юзера
      /*  try {
            System.out.println(categoryRepository.getByUserId(1));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        //получить категорию по id категории
        /* try {
            System.out.println(categoryRepository.getByCategoryId(1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //Обновить категорию
        /* Category category34 = new Category(4,"Музычка");
        try {
            categoryRepository.put(category34);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //Удалить категорию
      /*  try {
            categoryRepository.delete(2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        ////////////////////////////////////////////////////////////////////
        CardRepository cardRepository = new CardRepository();
        //Создаем новые карточки
       /* Card card = new Card("Любят пить взрослые и дети","Молоко");
        Card card2 = new Card("Любят пить взрослые дядя","Пиво");
        Card card3 = new Card("Любят пить взрослые тети","Вино");
        Card card4 = new Card("Главная музыка страны","Гимн");
        Card card5 = new Card("Лучшая музыка","Metal");
        Card card6 = new Card("Любят кушать взрослые и дети","Шоколад");
        Card card7 = new Card("Любят кушать на природе","Шашлындос");*/

        //Добавляем новые карточки
       /* try {
            cardRepository.post(1,card);
            cardRepository.post(1,card2);
            cardRepository.post(1,card3);
            cardRepository.post(4,card4);
            cardRepository.post(4,card5);
            cardRepository.post(5,card6);
            cardRepository.post(5,card7);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //Получаем все категории
        /*try {
            System.out.println(cardRepository.getAll());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //Получаем по id карточки
        /*try {
            System.out.println(cardRepository.getByCardId(1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //Получаем все карточки по id категории
        /*try {
            System.out.println(cardRepository.getByCategoryId(1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //Получаем все карточки по id юзера
        /*try {
            System.out.println(cardRepository.getByUserId(1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //Обновить карточку
       /* Card newCard = new Card(1,"Любят пить все и дети и взрослые","Молочко");
        try {
            System.out.println(cardRepository.put(newCard));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        //Удалить карточку
      /*  try {
            System.out.println(cardRepository.delete(1));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/


        //Удаляю пользователя, должны удалиться все связанные данные
        /*try {
            userRepository.delete(1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
    }
}

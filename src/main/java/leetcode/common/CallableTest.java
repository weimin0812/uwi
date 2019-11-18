package leetcode.common;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
    public static void main(String[] args) {
        Person person = new Person("shenxiu", 28);
        MyCallableThread callable = new MyCallableThread(person);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Person> result = executorService.submit(callable);

        String name = null;
        try {
            name = result.get().getName();
            System.out.println(name);
            executorService.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}


class MyCallableThread implements Callable<Person> {
    private Person person;

    public MyCallableThread(Person person) {
        this.person = person;
    }

    @Override
    public Person call() throws Exception {
        return person;
    }
}


class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{\"name\":" + name + ", \"age\":" + age + "\"}";
    }
}
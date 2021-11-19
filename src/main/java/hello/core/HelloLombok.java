package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(21);
        helloLombok.setName("name");
        System.out.println(helloLombok.getAge());
        System.out.println(helloLombok.getName());
        System.out.println("helloLombok = " + helloLombok);
    }
}

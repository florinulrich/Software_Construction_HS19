package Commands;

import Devices.Oven;
import Interfaces.Command;

import java.util.Scanner;

public class SetTimerOven implements Command {

    Oven oven;
    public SetTimerOven(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter timer [min] >> ");
        int timer = Integer.parseInt(myObj.next().trim());

        oven.setTimerMinutes(timer);

    }

    @Override
    public String getName() {
        return null;
    }
}
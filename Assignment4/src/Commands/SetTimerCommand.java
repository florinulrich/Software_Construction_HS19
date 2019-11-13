package Commands;

import Devices.Oven;
import Interfaces.Command;

import java.util.Scanner;

public class SetTimerCommand implements Command {

    Oven oven;
    public SetTimerCommand(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter timer [min] >> ");
        int timer = Integer.parseInt(myObj.next().trim());

        oven.setTimer(timer);

    }

    @Override
    public String getName() {
        return null;
    }
}
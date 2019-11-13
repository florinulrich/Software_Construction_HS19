package Commands;

import Devices.Oven;
import Interfaces.Command;

import java.util.Scanner;

public class SetTemperatureCommand implements Command {

    Oven oven;
    public SetTemperatureCommand(Oven oven) {
        this.oven = oven;
    }

    @Override
    public void execute() {

        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter timer [min] >> ");
        int temp = Integer.parseInt(myObj.next().trim());

        oven.setTemperature(temp);

    }

    @Override
    public String getName() {
        return null;
    }
}

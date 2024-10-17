// Command Interface - Define a common interface for all commands.
interface Command { //Declares a method execute that concrete command classes must implement.
    void execute();  //The method to be implemented by concrete commands to perform the action.
}

// Receiver Class - Define the class that performs the actual work when the command is executed.
class Light { //The receiver class that performs the actual operations.
    public void turnOn() {   //Method to turn on the light.
        System.out.println("Light is on");
    }

    public void turnOff() {   // Method to turn off the light.
        System.out.println("Light is off");
    }
}

// Concrete Command Classes - Implement concrete command classes for each action.
class TurnOnLightCommand implements Command {   //Concrete command to turn on the light.
    private Light light;   //Reference to the receiver.

    public TurnOnLightCommand(Light light) {  //Constructor initializes the receiver.
        this.light = light;
    }

    @Override   //Calls the turnOn method of the receiver.
    public void execute() {
        light.turnOn();
    }
}

class TurnOffLightCommand implements Command { //Concrete command to turn off the light.
    private Light light;  //Reference to the receiver.

    public TurnOffLightCommand(Light light) {  //Constructor initializes the receiver.
        this.light = light;
    }

    @Override    //Calls the turnOff method of the receiver.
    public void execute() {
        light.turnOff();
    }
}

// Invoker Class - Define the class that stores and invokes commands.
class RemoteControl {   //The invoker class that holds a command and triggers its execution.
    private Command command;   //The command to be executed.

    public void setCommand(Command command) {  // Sets the command.
        this.command = command;
    }

    public void pressButton() {   //Invokes the execute method of the command.
        command.execute();
    }
}

// Client Code - Invokes the execute method of the command.
class CommandPatternDemo {   //The client class that demonstrates the usage of the command pattern.
    public static void main(String[] args) {   //Main method to run the demonstration.
        Light livingRoomLight = new Light();   //Creates a receiver object.

        Command turnOnLight = new TurnOnLightCommand(livingRoomLight);   //Creates a command to turn on the light.
        Command turnOffLight = new TurnOffLightCommand(livingRoomLight);  //Creates a command to turn off the light.

        RemoteControl remote = new RemoteControl();  //Creates an invoker object.

        remote.setCommand(turnOnLight);   //Sets the command to turn on the light
        remote.pressButton();  //Executes the command to turn on the light.

        remote.setCommand(turnOffLight); //Sets the command to turn off the light.
        remote.pressButton();  //Executes the command to turn off the light.
    }
}
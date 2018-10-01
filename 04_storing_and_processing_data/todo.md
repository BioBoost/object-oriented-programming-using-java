Aan bord het voorbeeld gebracht van alle getallen selecteren die even zijn doormiddel van modulo operator.

Nog een toepassing: beperking van de range van een waarde. Bijvoorbeeld tussen 0 en 100. Wat als je bij je variable een waarde wil optellen ?
x = (x + 15) % 101
Echter eerst aan bord gebracht met %100 en dan aangegeven wat een off by 1 error is.

In de eerste challenge mag die byte kolom weg.

Op het einde van het hoofdstuk een sectie plaatsen: requesting data from the user via the terminal. Dit is nodig voor de oefeningen. Heel simpel:
```java
    Scanner console = new Scanner(System.in);

    System.out.print("Please enter a number: ");
    int number = console.nextInt();
    System.out.println("You entered the value " + number);
```
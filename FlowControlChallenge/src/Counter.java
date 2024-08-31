import java.security.InvalidParameterException;
import java.util.Scanner;

public class Counter {
	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		System.out.println("Write the first parameter");
		int parameterOne = terminal.nextInt();
		System.out.println("Write the second parameter");
		int parameterTwo = terminal.nextInt();
		
		try {
			//chamando o método contendo a lógica de contagem
			count(parameterOne, parameterTwo);
		
		}catch (InvalidParameterException exception) {
			//imprimir a mensagem: O segundo parâmetro deve ser maior que o primeiro
			System.err.println("The second parameter must be higher than the first.");
		}
	}
	static void count(int parameterOne, int parameterTwo) throws InvalidParameterException {
		//validar se parametroUm é MAIOR que parametroDois e lançar a exceção
		if (parameterOne > parameterTwo) {
			System.out.println("The second parameter must be higher than the first.");
		}
		//realizar o for para imprimir os números com base na variável contagem
		for (int counting = parameterOne ; parameterOne < parameterTwo ; counting++) {
			counting = parameterTwo - parameterOne;
			System.out.println(counting);
			break;
		}
	}
}

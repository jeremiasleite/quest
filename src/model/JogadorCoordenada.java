package model;

public class JogadorCoordenada {

	public int getXJogador(int jogador, int casa){

		int[][] coordX = {{535, 529, 503, 469, 427, 376, 306, 246, 208, 178, 158, 152, 163, 191, 229, 274, 326, 379, 435, 475, 509, 531, 556},
				{555, 582, 546, 500, 448, 384, 300, 221, 169, 133, 110, 101, 110, 147, 198, 253, 317, 386, 452, 507, 547, 580, 556}};

		if(casa > 22) casa = 22;
		
		return coordX[jogador][casa];
	};

	public int getYJogador(int jogador, int casa){

		int[][] coordY = {{337, 397, 445, 479, 504, 517, 518, 493, 457, 417, 369, 316, 254, 201, 163, 140, 123, 127, 140, 167, 203, 245, 291},
				{337, 417, 474, 517, 550, 569, 570, 536, 493, 443, 382, 316, 240, 172, 120, 90, 70, 72, 82, 124, 173, 228, 291}};

		if(casa > 22) casa = 22;
		
		return coordY[jogador][casa];
	};
}

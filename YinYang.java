/*
*Author Franz Brandl
*
*Messing around with console output and math stuff
*/

public final class YinYang {

	private static final int _size = 81;	// odd number for straight mid

	private static String faceSign;
	private static String eyeSign;
	private static String pupilSign;


	public static void main(String[] args) {
		DrawGridCircle(_size);
	}

	// math function for calculation of positive part
	private static double HalbKreisFunktionPositive(double x, double r, double xMid, double yMid){
		return yMid + Math.sqrt(Math.pow(r, 2.0D) - Math.pow(x - xMid, 2.0D));
	}

	// math function for calculation of negative part
	private static double HalbKreisFunktionNegative(double x, double r, double xMid, double yMid){
		return yMid - Math.sqrt(Math.pow(r, 2.0D) - Math.pow(x - xMid, 2.0D));
	}


	private static void DrawGridCircle(int size){

		for (int y = 0; y < size; y++){

			for (int x = 0; x < size; x++){

				// Calculation of the outer circle, called face
				int pointYFacePosi = (int)Math.round(HalbKreisFunktionPositive(x, _size / 2, _size / 2, _size / 2));
				int pointYFaceNega = (int)Math.round(HalbKreisFunktionNegative(x, _size / 2, _size / 2, _size / 2));

				// Calculation of the upper mid circle, called eye1
				int pointYEye1Posi = (int)Math.round(HalbKreisFunktionPositive(x, _size / 4, _size / 2, _size / 4));
				int pointYEye1Nega = (int)Math.round(HalbKreisFunktionNegative(x, _size / 4, _size / 2, _size / 4));

				// Calculation of the lower mid circle, called eye2
				int pointYEye2Posi = (int)Math.round(HalbKreisFunktionPositive(x, _size / 4, _size / 2, _size / 4 * 3));
				int pointYEye2Nega = (int)Math.round(HalbKreisFunktionNegative(x, _size / 4, _size / 2, _size / 4 * 3));

				// Calculation of the upper most inner circle, called pupil1
				int pointYPupil1Posi = (int)Math.round(HalbKreisFunktionPositive(x, _size / 8, _size / 2, _size / 4));
				int pointYPupil1Nega = (int)Math.round(HalbKreisFunktionNegative(x, _size / 8, _size / 2, _size / 4));

				// Calculation of the lower most inner circle, called pupil2
				int pointYPupil2Posi = (int)Math.round(HalbKreisFunktionPositive(x, _size / 8, _size / 2, _size / 4 * 3));
				int pointYPupil2Nega = (int)Math.round(HalbKreisFunktionNegative(x, _size / 8, _size / 2, _size / 4 * 3));

				// Determine faceSign
				if (x < _size / 2) {
					faceSign = "L";	// white space
				}
				else {
					faceSign = "X";	// black space
				}

				// Determine eyeSign & pupilSign
				if (y < _size / 2) {
					eyeSign = "L";
					pupilSign = "X";
				}
				else {
					eyeSign = "X";
					pupilSign = "L";
				}

				if (y < pointYFaceNega || y > pointYFacePosi) {
					System.out.print(" ");	// don't draw anything outside the YinYang symbol
				}
				else {

					// space in the face
					if ((y < pointYEye1Nega || y > pointYEye1Posi) && (y < pointYEye2Nega || y > pointYEye2Posi)) {
						System.out.print(faceSign);
					}
					else {
						// space in the eyes
						if ((y < pointYPupil1Nega || y > pointYPupil1Posi) && (y < pointYPupil2Nega || y > pointYPupil2Posi)) {
							System.out.print(eyeSign);
						}
						// space in the pupils
						else{
							System.out.print(pupilSign);
						}
					}
				}
			}
			System.out.println("");
		}
	}
}

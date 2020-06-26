
package ecuacionii;


public class Logica {

    double constante1 = 0;
    double constante2 = 0;
    double auxiliar1 = 0;
    double auxiliar2 = 0;
    double numA2;
    double numB2;
    double coeficientes[]=new double[2];

    public void ecuacionRemplazar(double numA, double numB, String tipo) {

        if (tipo == "eq1") {
            forma1(numA, numB);

        }
        if (tipo == "eq2") {
            forma2(numA, numB);
        }
    }

    public void forma1(double numA, double numB) {
        double indiceFn = 1;
        double indiceFn2;
        double condicion1 = 1;
        double condicion2 = numA + numB;

        System.out.println("Solucion Paso a Paso");
        System.out.println("Fn = " + numA + "+ " + numB + "*F_{n/2}");
        System.out.println("Considerando que: n= 2^i");
        System.out.println(indiceFn + "F_{2^i} + (" + (numB * (-1)) + "*F_{2^i-1}) = " + numA);
        System.out.println("Cambiando los subindices en funcion i:");
        System.out.println(indiceFn + " F_i + (" + (numB * (-1)) + "*F_{i-1}) = " + numA);
        System.out.println("Remplazandoi por i-1 y  Multiplicando por (-1)  se obtiene:");

        numA2 = numA * (-1);
        numB2 = numB * (-1);
        indiceFn2 = indiceFn * (-1);

        System.out.println(indiceFn2 + " F_{i-1} + (" + (numB2 * (-1)) + "*F_{i-2}) = " + numA2);
        System.out.println("Sumando las ecuaciones para obtener la homogenea:");

        double b = (numB * (-1)) + indiceFn2;
        double c = numB2 * (-1);

        System.out.println(indiceFn + " F_{i} + (" + b + "*F_{i-1})+ (" + c + "*F_{i-2}) = 0");

        double[] raiz = new double[2];
        raiz[0] = (-b + Math.sqrt((Math.pow(b, 2)) - (4 * indiceFn * c))) / (2 * indiceFn);
        raiz[1] = (-b - Math.sqrt((Math.pow(b, 2)) - (4 * indiceFn * c))) / (2 * indiceFn);

        System.out.println("Las dos raices son (" + raiz[0] + "," + raiz[1] + ")");

        if (raiz[0] == raiz[1]) {
            System.out.println("La solucion General es:");
            System.out.println("** Se presenta Multiplicidad**");
            System.out.println("F(i) =  C1*" + raiz[0] + "^i + i*C2*" + raiz[1] + "^i");
            System.out.println("Remplazando i por lg(n)");
            System.out.println("F(n) =  C1*" + raiz[0] + "^lg(n) + lg(n)*C2*" + raiz[1] + "^lg(n)");
            System.out.println("Las condiciones iniciales se calculan con:");
            System.out.println("Fn = " + numA + "+ " + numB + "*F_{n/2}");
            System.out.println("F(1) = " + condicion1);
            System.out.println("F(2) = " + condicion2);
            System.out.println("Las ecuaciones para calcular C1 y C2 son:");
            System.out.println("C1*1^lg(" + raiz[0] + ") + C2*lg(1)*1^lg(" + raiz[1] + ") = " + condicion1);
            System.out.println("C1*2^lg(" + raiz[0] + ") + C2*lg(2)*2^lg(" + raiz[1] + ") = " + condicion2);
            System.out.println("C1*" + raiz[1] + " + C2*lg(1)*" + raiz[1] + " = " + condicion1);
            System.out.println("C1*" + raiz[0] + " + C2*lg(2)*" + raiz[1] + " = " + condicion2);
            System.out.println("Matriz para Gauss");

            auxiliar1 = Math.log10(1) / Math.log10(2);
            auxiliar2 = Math.log10(2) / Math.log10(2);

            System.out.println("<html><body><table border = \"1\"><tr><td>" + raiz[1] + "</td><td>" + auxiliar1 + "</td><td>" + condicion1 + "</td></tr><tr><td>" + raiz[0] + "</td><td>" + auxiliar2 + "</td><td>" + condicion2 + "</td></tr> </table></body></html>");

            coeficientes=Gauss(raiz[1], auxiliar1, condicion1, raiz[0], auxiliar2, condicion2);

            System.out.println("Donde C1 y C2 son:");
            System.out.println("C1 = " + coeficientes[0]);
            System.out.println("C2 = " + coeficientes[1]);
            System.out.println("La solucion es: ");
            System.out.println("F(n) = " + (coeficientes[0] * Math.pow(raiz[0], Math.log10(raiz[1]) / Math.log10(2))) + "+(" + coeficientes[1] + ")* lg(n)");
        } else {
            System.out.println("La solucion General es:");
            System.out.println("F(i) =  C1*" + raiz[0] + "^i + i*C2*" + raiz[1] + "^i");
            System.out.println("Remplazando i por lg(n)");
            System.out.println("F(n) =  C1*" + raiz[0] + "^lg(n) + lg(n)*C2*" + raiz[1] + "^lg(n)");
            System.out.println("Las condiciones iniciales se calculan con:");
            System.out.println("Fn = " + numA + "+ " + numB + "*F_{n/2}");
            System.out.println("F(1) = " + condicion1);
            System.out.println("F(2) = " + condicion2);
            System.out.println("Las ecuaciones para calcular C1 y C2 son:");
            System.out.println("C1*1^lg(" + raiz[0] + ") + C2*1^lg(" + raiz[1] + ") = " + condicion1);
            System.out.println("C1*2^lg(" + raiz[0] + ") + C2*2^lg(" + raiz[1] + ") = " + condicion2);
            System.out.println("C1*" + raiz[1] + " + C2* " + raiz[1] + " = " + condicion1);
            System.out.println("C1*" + raiz[0] + " + C2*" + raiz[1] + " = " + condicion2);
            System.out.println("Matriz para Gauss");
            System.out.println("<html><body><table><tr><td>" + raiz[1] + "</td><td>" + raiz[1] + "</td><td>" + condicion1 + "</td></tr><tr><td>" + raiz[0] + "</td><td>" + raiz[1] + "</td><td>" + condicion2 + "</td></tr> </table></body></html>");
            coeficientes=Gauss(raiz[1], raiz[1], condicion1, raiz[0], raiz[1], condicion2);
            System.out.println("Donde C1 y C2 son:");
            System.out.println("C1 = " + coeficientes[0]);
            System.out.println("C2 = " + coeficientes[1]);
            System.out.println("La solucion es:");
            System.out.println("F(n) = " + (coeficientes[0] * Math.pow(raiz[0], Math.log10(raiz[1]) / Math.log10(2))) + "* n^" + (Math.log10(raiz[0]) / Math.log10(2)) + "+(" + coeficientes[1] + ")");
        }
        System.out.println();
    }

    public void forma2(double numA, double numB) {
        double indiceFn = 1;
        double indiceFn2;
        double condicion1 = 1;
        double condicion2 = numB + Math.pow(2, numA);

        System.out.println("Solucion Paso a Paso");
        System.out.println("Fn = n^" + numA + "+ " + numB + "*F_{n/2}");
        System.out.println("Considerando que: n= 2^i");
        System.out.println(indiceFn + "F_{2^i} + (" + (numB * (-1)) + "*F_{2^i-1}) = (" + indiceFn + ")2^" + numA + "i" + numA);
        System.out.println("Cambiando los subindices en funcion i:");
        System.out.println(indiceFn + " F_i + (" + (numB * (-1)) + "*F_{i-1}) = (" + indiceFn + ")2^" + numA + "i");
        System.out.println("Remplazandoi por i-1 y  Multiplicando por (-1)  se obtiene:");

        numA2 = numA * (-1);
        numB2 = numB * (-1);
        indiceFn2 = indiceFn * (-1);

        System.out.println(indiceFn2 + " F_{i-1} + (" + (numB2 * (-1)) + "*F_{i-2}) = (" + indiceFn2 + ")2^(" + numA + "i)" + numA2);
        System.out.println(indiceFn2 * numA2 + " F<sub>i-1</sub> + (" + (numB2 * (-1)) * numA2 + "*F<sub>i-2</sub>) = (" + indiceFn2 + ")2<sup>" + numA + "i</sup>");
        System.out.println("Sumando las ecuaciones para obtener la homogenea:");

        double b = (numB * (-1)) + (indiceFn2 * numA2);
        double c = numB2 * (-1) * numA2;

        System.out.println(indiceFn + " F<sub>i</sub> + (" + b + "*F<sub>i-1</sub>)+ (" + c + "*F<sub>i-2</sub>) = 0");

        double[] raiz = new double[2];

        raiz[0] = (-b + Math.sqrt((Math.pow(b, 2)) - (4 * indiceFn * c))) / (2 * indiceFn);
        raiz[1] = (-b - Math.sqrt((Math.pow(b, 2)) - (4 * indiceFn * c))) / (2 * indiceFn);

        System.out.println("Las dos raices son (" + raiz[0] + "," + raiz[1] + ")");

        if (raiz[0] == raiz[1]) {
            System.out.println("La solucion General es:");
            System.out.println("** Se presenta Multiplicidad**");
            System.out.println("F(i) =  C1*" + raiz[0] + "^i + i*C2*" + raiz[1] + "^i");
            System.out.println("Remplazando i por lg(n)");
            System.out.println("F(n) =  C1*" + raiz[0] + "^lg(n) + lg(n)*C2*" + raiz[1] + "^lg(n)");
            System.out.println("Las condiciones iniciales se calculan con:");
            System.out.println("Fn = " + numA + "+ " + numB + "*F_{n/2}");
            System.out.println("F(1) = " + condicion1);
            System.out.println("F(2) = " + condicion2);
            System.out.println("Las ecuaciones para calcular C1 y C2 son:");
            System.out.println("C1*1^lg(" + raiz[0] + ") + C2*lg(1)*1^lg(" + raiz[1] + ") = " + condicion1);
            System.out.println("C1*2^lg(" + raiz[0] + ") + C2*lg(2)*2^lg(" + raiz[1] + ") = " + condicion2);
            System.out.println("C1*" + raiz[1] + " + C2*lg(1)*" + raiz[1] + " = " + condicion1);
            System.out.println("C1*" + raiz[0] + " + C2*lg(2)*" + raiz[1] + " = " + condicion2);
            System.out.println("Matriz para Gauss");

            auxiliar1 = Math.log10(1) / Math.log10(2);
            auxiliar2 = (Math.log10(2) / Math.log10(2)) * raiz[1];

            System.out.println("<html><body><table><tr><td>" + indiceFn + "</td><td>" + auxiliar1 + "</td><td>" + condicion1 + "</td></tr><tr><td>" + raiz[0] + "</td><td>" + auxiliar2 + "</td><td>" + condicion2 + "</td></tr> </table></body></html>");

            coeficientes=Gauss(raiz[1], auxiliar1, condicion1, raiz[0], auxiliar2, condicion2);

            System.out.println("Donde C1 y C2 son:");
            System.out.println("C1 = " + coeficientes[0]);
            System.out.println("C2 = " + coeficientes[1]);
            System.out.println("La solucion es: ");
            System.out.println("F(n) = 1*n^" + numA + "+1*lg(n)*n^" + numA + "");
        } else {
            System.out.println("La solucion General es:");
            System.out.println("F(i) =  C1*" +  raiz[0]+"<sup>i</sup> + C2*" + raiz[1]+"<sup>i</sup>");
            System.out.println("Remplazando i por lg(n)");
            System.out.println("F(n) =  C1*" +  raiz[0]+"<sup>lg(n)</sup> + C2*" + raiz[1]+"<sup>lg(n)</sup>");
            System.out.println("Las condiciones iniciales se calculan con:");
            System.out.println("Fn = " + numA + "+ " + numB + "*F_{n/2}");
            System.out.println("F(1) = " + condicion1);
            System.out.println("F(2) = " + condicion2);
            System.out.println("Las ecuaciones para calcular C1 y C2 son:");
            System.out.println("C1*1 <sup>lg("+  raiz[0]+")</sup> + C2*1<sup>lg(" + raiz[1]+")</sup> = "+ condicion1);
            System.out.println("C1*2 <sup>lg("+  raiz[0]+")</sup> + C2*2<sup>lg(" + raiz[1]+")</sup> = "+ condicion2);
            System.out.println("C1*"+ indiceFn+" + C2*" + indiceFn+" = "+ condicion1);
            System.out.println("C1*"+  raiz[0]+" + C2*" + raiz[1]+" = "+ condicion2);
            System.out.println("Matriz para Gauss");

            auxiliar1 = Math.log10(1) / Math.log10(2);
            auxiliar2 = (Math.log10(2) / Math.log10(2)) * raiz[1];

            System.out.println("<html><body><table><tr><td>"+indiceFn+"</td><td>"+indiceFn+"</td><td>"+condicion1+"</td></tr><tr><td>"+raiz[0]+"</td><td>"+raiz[1]+"</td><td>"+condicion2+"</td></tr> </table></body></html>");

            coeficientes=Gauss(indiceFn,indiceFn,condicion1,raiz[0],raiz[1],condicion2);

            System.out.println("Donde C1 y C2 son:");
            System.out.println("C1 = " + coeficientes[0]);
            System.out.println("C2 = " + coeficientes[1]);
            System.out.println("La solucion es: ");
            System.out.println("F(n) = "+(coeficientes[0]*Math.pow(raiz[0],Math.log10(indiceFn) / Math.log10(2)))+ "* n <sup>"+(Math.log10(raiz[0]) / Math.log10(2)) +"</sup>+("+coeficientes[1]+")* n <sup>"+(Math.log10(raiz[1]) / Math.log10(2)));
        }
    }
    
    public void forma3(double numA, double numB, double numC){
        
    }

    public double[] Gauss(double n1, double n2, double n3, double n4, double n5, double n6) {
        double nAp1;
        double nAp2;
        double nAp3;
        if (n1 != 1) {

            n2 = n2 / n1;
            n3 = n3 / n1;
            n1 = n1 / n1;

        }
        if (n4 != 0) {

            nAp1 = n4 * n1;
            nAp2 = n4 * n2;
            nAp3 = n4 * n3;

            n4 = n4 - nAp1;
            n5 = n5 - nAp2;
            n6 = n6 - nAp3;
        }
        if (n5 != 1) {

            n4 = n4 / n5;
            n6 = n6 / n5;
            n5 = n5 / n5;

        }
        constante2 = n6;

        constante1 = n3 - (n2 * constante2);
        
        double coe[]=new double[2];
        coe[0]=constante1;
        coe[1]=constante2;
        return coe;
    }

}

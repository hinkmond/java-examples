/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hiwong
 */
public class JavaPuzzlis {

    private static class Elementary {

        public static void doIt(String[] args) {
            System.out.println(12345 + 5432l);
        }

    }

    private static class Multicast {

        private static void doIt(String[] args) {
            System.out.println((int) (char) (byte) -1);
        }

    }


    // JavaPuzzlis Main
    public static void main(String[] args) {

       Elementary.doIt(null);
//       Multicast.doIt(null);

    }



}

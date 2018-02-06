/*
 * The MIT License
 *
 * Copyright 2018 Ubaldo Hidalgo Arriaga.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package PreparacionFebrero;

/**
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Pruebas {
    
    public static void main(String[] args) {

        MultiContador res = new MultiContador(10, 10, 50);

        try{
        System.out.println("Multicontador creado----------\n");
        System.out.println(res.toString());
        System.out.println("incremento----------\n");
        res.incrementaContador(0);
        System.out.println(res.toString());
        System.out.println("decremento----------\n");
        res.decrementaContador(0);
        System.out.println(res.toString());
        System.out.println("incremento GENERAL----------\n");
        res.incrementoGeneral();
        System.out.println( res.toString());
         System.out.println("decremento GENERAL----------\n");
        res.decrementoGeneral();
        System.out.println(res.toString());

  

        }catch(IllegalArgumentException e){
             System.out.println("Funsiona");
        }catch(IllegalStateException e){
             System.out.println("Funsiona");
        }catch(Exception e){
             System.out.println("Argo ha petao");
             e.printStackTrace();
        }
        
        try{
      

        MultiContador res1 = new MultiContador(10, 10, 11);
        System.out.println("incremento POR ENCIMA DE LO PERMITIDO----------\n");
        res1.incrementaContador(0);
        res1.incrementaContador(0);
        System.out.println(res.toString());
     

        }catch(IllegalArgumentException e){
            System.out.println("Funsiona");
        }catch(IllegalStateException e){
             System.out.println("Funsiona");
        }catch(Exception e){
             System.out.println("Argo ha petao");
             e.printStackTrace();
        }
        
        
        try{
      
        
         MultiContador res2 = new MultiContador(10, 10, 11);
        System.out.println("incremento GENERAL MAS DE LO PERMITIDO----------\n");
        res2.incrementoGeneral();
        res2.incrementoGeneral();
        System.out.println(res.toString());


        }catch(IllegalArgumentException e){
             System.out.println("Funsiona");
        }catch(IllegalStateException e){
             System.out.println("Funsiona");
        }catch(Exception e){
             System.out.println("Argo ha petao");
             e.printStackTrace();
        }
        
        
        




    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

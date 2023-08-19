import java.util.Scanner;
import java.text.DecimalFormat;
public class DeterminePrice
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        //Decimalformat bm = new Decimalformat("0.00");
        final int SIZE =3;
        String[] itemName = new String[SIZE];
        double[] price = new double[SIZE];
        int[] Barcode = new int[SIZE];
        double[] vat = new double[SIZE];
        double[] SellingPrice =new double[SIZE];


        for(int i=0;i<SIZE;i++)
        {
            System.out.print("Enter the barcode of the item "+ (i+1) +" :");
            Barcode[i] = input.nextInt();
            Scanner kb = new Scanner(System.in);
            System.out.print("Enter the name of the item "+ (i+1) +" :");
            itemName[i] = kb.nextLine();
            System.out.print("Enter the price of the item "+ (i+1) +" :");
            price[i] = kb.nextDouble();

        }
        calculateVat(price,vat);
        calculateSellingPrice(price,vat,SellingPrice);
        displayReport(Barcode,itemName,price,SellingPrice,vat);
        int highest = highestSellingPrice(SellingPrice);

        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("\nThe Item with the highest Selling Price is Barcode: " + Barcode[highest] + " Item Name: " + itemName[highest] + "\nwith VAT of: " + df.format(vat[highest]) + " , Price of: R" + df.format(price[highest]));


    }
    public static void calculateVat(double[] p_price,double[] p_vat)
    {


        for (int x = 0; x < p_price.length; x++) {
            double priceAmount = p_price[x] * 0.15;
            p_vat[x] = priceAmount;

        }
    }

    public static void calculateSellingPrice(double[] p_price,double[] p_vat,double[] p_SellingPrice)
    {
        for(int y=0;y<p_SellingPrice.length;y++)
        {
            p_SellingPrice[y] = p_price[y] + p_vat[y];
        }
    }


    public static void displayReport(int[] p_Barcode,String[] p_itemName,double[] p_price,double[] SellingPrice,double[] p_vat)
    {
        DecimalFormat bm = new DecimalFormat("0.00");

        System.out.print("Barcode"+ "\t" +"itemname"+"\t"+"price"+"vat"+"Sellingprice");

        for(int a=0;a< p_price.length;a++)
        {
            System.out.print("Barcodre[a]"+"\t"+"itemname[a]"+"\t"+"bm.format(price[p])"+"\t"+"bm.format(vat[a])"+"\t"+"bm.format(Sellingprice[a])");
        }
    }
    public static int highestSellingPrice(double[] p_SellingPrice)
    {
        int highestPosition = 0;
        double highest = 0.0;

        for(int r=0;r<p_SellingPrice.length;r++)
        {
            if(p_SellingPrice[r]>highest)
            {
                highest = p_SellingPrice[r];
                highestPosition = r;

            }
        }
        return highestPosition;
    }

}

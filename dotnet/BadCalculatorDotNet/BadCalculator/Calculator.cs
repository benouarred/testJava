using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BadCalculator
{
    class Calculator
    {
        static void Main(string[] args)
        {
            Console.WriteLine(Calculator.Compute("3 plus 4"));
            Console.WriteLine(Calculator.Compute("3 moins 4"));
            Console.WriteLine(Calculator.Compute("3 fois 4"));
            Console.WriteLine(Calculator.Compute("3 divisé 4"));
        }

        private static int? Compute(String input)
        {
            int opsi = input.IndexOf(' ');
            int opei = input.LastIndexOf(' ');
            String operation = input.Substring(opsi + 1, opei);

            //System.out.println("_" + operation + "_");

            if (operation == "plus")
            {
                Console.WriteLine("Plus");
                return Int32.Parse(input.Substring(0, input.IndexOf(' '))) + Int32.Parse(input.Substring(input.LastIndexOf(' ') + 1));
            }
            else if (operation == "moins")
            {
                Console.WriteLine("Moins");
                return Int32.Parse(input.Substring(0, input.IndexOf(' '))) - Int32.Parse(input.Substring(input.LastIndexOf(' ') + 1));
            }
            else if (operation == "fois")
            {
                Console.WriteLine("Fois");
                return Int32.Parse(input.Substring(0, input.IndexOf(' '))) * Int32.Parse(input.Substring(input.LastIndexOf(' ') + 1));
            }
            else if (operation == "divisé")
            {
                Console.WriteLine("Divisé");
                return Int32.Parse(input.Substring(0, input.IndexOf(' '))) / Int32.Parse(input.Substring(input.LastIndexOf(' ') + 1));
            }

            return null;

        }


    }
}

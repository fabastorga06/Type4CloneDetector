package Test;
extern int arreglo1[];
extern int arreglo2[];
 
int suma1 = 0;
int suma2 = 0;
float promedio1 = 0.0;
float promedio2 = 0.0;
 
for (int i = 0; i < 4; i++)
{
   suma1 += arreglo1[i];
}
promedio1 = suma1 / 4;
 
for (int i = 0; i < 4; i++)
{
   suma2 += arreglo2[i];
}
promedio2 = suma2 / 4;


//-----------------------------

int calculaPromedio (int* arreglo_de_4)
{
   int suma = 0;
   for (int i = 0; i < 4; i++)
   {
       suma += arreglo_de_4[i];
   }
   return suma / 4;
}


int main() {
   int x = 1;
   int y = x + 5;
   return y;
}


int func4() {
   int n = 5;
   return ++n;
}

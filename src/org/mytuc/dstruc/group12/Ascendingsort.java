public class Ascendingsort{
public static void Aufgabe5(AnimalBoarding list) {
     System.out.println("==========================Aufgabe5=======================");
     ListElement point = list.getFirstElem();
     ListElement last = list.getLastElem();
     int size = 0;
        while (point != last.getNextElem()) {
         size++;
         point = point.getNextElem();
        }
        Animal[] animals = new Animal[size];
        point = list.getFirstElem();
        int index = 0;
        while (point != last.getNextElem()) {
         animals[index++] = resolveAnimal(point.obj.toString());
        }
        doSort(animals, new Comparator<Animal>() {
   @Override
   public int compare(Animal o1, Animal o2) {
    return o1.getSpecies().compareTo(o2.getSpecies());
   }
        });
        for (Animal a : animals) {
         System.out.println("species:" + a.getSpecies() + ";name:" + a.getName());
        }
    }
    
    private static Animal[] doSort(Animal[] array, Comparator<Animal> c) {
  for (int i = 0; i < array.length; i++) {
   for (int j = i+1; j < array.length; j++) {
    if (c.compare(array[i], array[j]) > 0) {
     Animal temp = array[i];
     array[i] = array[j];
     array[j] = temp;
    }
   }
  }
  return array;
 }
 }

 private static Animal resolveAnimal(String line) {
  String[] params = line.split(";");
  return new Animal(params[0],params[1],params[2],Integer.valueOf(params[3]),Integer.valueOf(params[4]));
 }

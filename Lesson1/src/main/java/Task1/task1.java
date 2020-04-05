package Task1;

class Stats<T extends Object> {
        private T[] mus;

        public Stats(T[] mus) {
            this.mus = mus;
        }

    public T[] getMus() {
        return mus;
    }

    public void setMus(T[] mus) {
        this.mus = mus;
    }
    public int getLength(){
        return mus.length;
    }
    static void Echange(Stats mus,int Ea, int Eb){
            if (Ea < 0 || Ea >= mus.getLength() || Eb < 0 || Eb >= mus.getLength() || Ea == Eb) {
                System.out.println("Неправильно указаны номера элементов");
            } else {
                Object[] num1 = mus.getMus();
                Object next = num1[Ea];
                num1[Ea] = num1[Eb];
                num1[Eb] = next;
                mus.setMus((Object[]) num1);

            }

        }
        public static void main(String[] args) {
            String[] smus = {"a", "b", "c", "d"};
            Integer[] imas = {1, 2, 3, 4};
            Stats<String> sStats = new Stats<>(smus);
            Stats<Integer> iStas = new Stats<>(imas);
            for (int i = 0; i < sStats.getLength(); i++)
                System.out.print(sStats.getMus()[i]);
            System.out.println();
            for (int i = 0; i < iStas.getLength(); i++)
                System.out.print(iStas.getMus()[i]);
            System.out.println();

            // Задаем элементы массива и массив который нужно заменить
            Echange(sStats, 0, 2);
            Echange(iStas, 0, 2);

            for (int i = 0; i < sStats.getLength(); i++)
                System.out.print(sStats.getMus()[i]);
            System.out.println();
            for (int i = 0; i < iStas.getLength(); i++)
                System.out.print(iStas.getMus()[i]);


        }
    }

class Person {
        private Bil3 bil;

        public Person(Bil3 minbil){
                bil = minbil;

        }

        public void printing(){
                System.out.print("Bilnummeret til bilen som personen eier" + bil.hentNummer());
        }
}

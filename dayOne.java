// Import this class to handle errors
import java.io.*;  // Import the File class
import java.util.*; // Import the Scanner class to read text files
import java.util.stream.Collectors;

import util.Tuple;

public class dayOne{
        ArrayList<Integer> leftList;
        ArrayList<Integer> rightList;
        
        public dayOne(String inputFile){
            //! NB Methods that deal with instance variables should NOT
            //! EVER deal with this.Var directly. I.e. should be "stateless"
            //! Meaning it doesn't depend on the instance var already being
            //! instantiated or not.
            
            Tuple<ArrayList<Integer>,ArrayList<Integer>> data = parseData(inputFile);
        
            this.leftList = data.getItemOne();
            this.rightList =  data.getItemTwo();

        }
        
        public ArrayList<Integer> getRightList(){
            return this.rightList;
        }
        public ArrayList<Integer> getLeftList(){
            return this.leftList;
        }

        private Tuple< ArrayList<Integer>, ArrayList<Integer>> parseData(String filePath)
        {
            //! Wrapped BufferedReader(): Decorator design Pattern
            //! Passing an IO reade, e.g. FileReader adds chunks of the inner object's
            //! input, making it more efficient.
            //! In this cxample: FileReader, fetches charatacter-by-characters from the
            //! file system. When pasesed to the BufferedReader constructor, Buffered
            //! takes chunks of characters from the IO stream into memory from the
            //! filesystem or network

            ArrayList<Integer> leftList = new ArrayList<>();
            ArrayList<Integer> rightList = new ArrayList<>();

            try
            {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line;
                String[] parts = new String[2];

                while ((line = reader.readLine()) != null)
                {
                    parts = line.trim().split("   ");
                    if (parts.length == 2){
                        leftList.add(Integer.parseInt(parts[0]));
                        rightList.add(Integer.parseInt(parts[1]));
                    }
                }
                reader.close();
            }
            catch( Exception e)
            {
                System.out.println(e);
            }
            return new Tuple<ArrayList<Integer>,ArrayList<Integer>>(leftList, rightList);
        }

        public int getSum(){
            //! Passing null to sort() uses the default sorting for the data type
            leftList.sort(null);
            rightList.sort(null);
            int size = leftList.size();
            int totDistance = 0;
            //! NB: Must initialize i; initialize means SET AN INITIAL VALUE!
            for (int i=0; i < size; i++){
                totDistance += Math.abs(leftList.get(i)-rightList.get(i));                
            }
            return totDistance;
        }

        private HashMap<Integer, Integer> createMap(ArrayList<Integer> arrayList){
            // Create a HashMap using streams
            HashMap<Integer, Integer> hashMap = arrayList.stream()
            .collect(Collectors.toMap(
                    key -> key,             // Key mapping: use the element itself as the key
                    key -> 0,  // Value mapping: assign a default value
                    (existing, replacement) -> existing, // Merge function to handle duplicate keys
                    HashMap::new            // Supplier for the resulting HashMap
            ));

            return hashMap;
        }

        public HashMap<Integer, Integer> createCounterMap(
                                    ArrayList<Integer> lefttList,
                                    ArrayList<Integer> rightList){
            
                HashMap<Integer, Integer> counterDict = createMap(leftList);
                System.out.println(counterDict.get(28686));

                rightList.forEach(num -> counterDict.computeIfPresent(num,
                                    (key, value) -> value+1));

            return counterDict;
        }

        public int calculateSimilarityScore(ArrayList<Integer> leftList, 
                                            ArrayList<Integer> rightList){
            
            HashMap<Integer, Integer> counterDict = createCounterMap(leftList, rightList);
            
            int score = 0;
            //* NB!!!! Simple list iteration construct! */
            for (Integer key : counterDict.keySet()){
                score = score + (key * counterDict.get(key));
            }

            return score;
        }
        
        public static void main(String[] args){
        dayOne obj = new dayOne("data/dayOne_in.txt");
        System.out.println(obj.calculateSimilarityScore(obj.getLeftList(), obj.getRightList()));
        
    }
}
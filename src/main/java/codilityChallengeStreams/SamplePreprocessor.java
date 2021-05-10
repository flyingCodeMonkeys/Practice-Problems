package codilityChallengeStreams;
import java.math.BigInteger;
import java.util.*;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.math.BigDecimal.ZERO;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.groupingBy;

public class  SamplePreprocessor {

        //private final SampleNormalizer normalizer;

//        SamplePreprocessor(SampleNormalizer normalizer) {
//            this.normalizer = normalizer;
//        }

        Stream<BigDecimal> preprocess(Stream<BigDecimal> input) {
            Stream<BigDecimal> filteredNoise = filterNoise(input);
            AtomicInteger counter = new AtomicInteger();
            AtomicInteger index = new AtomicInteger(0);

            //FixedSizeSpliterator

            filteredNoise.collect(groupingBy(x -> index.getAndIncrement() / 3))
                    .entrySet().stream()
                    .sorted(Map.Entry.comparingByKey()).map(Map.Entry::getValue);

            return null;
        }

        Stream<BigDecimal> filterNoise(Stream<BigDecimal> input){
            return input.filter(i -> i.compareTo(new BigDecimal(0)) > 0);
        }

//        Stream<List<BigInteger>> triplet(Stream<BigInteger> stream){
//            //IntStream.iterate(0, i -> i < )
//            Spliterator<BigInteger> split = stream.spliterator();
//            while(true){
//                List<BigInteger> chunk = new ArrayList<>(3);
//                for(int i = 0; i < chunk.size(); i++){
//                    split.tryAdvance(chunk::add);
//
//                };
//
//                if(chunk.isEmpty()) break;
//            }
//
//            return
//        }

}

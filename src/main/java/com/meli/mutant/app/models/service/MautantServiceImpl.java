package com.meli.mutant.app.models.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Service
public class MautantServiceImpl implements IMutantService {

    List<String> constant= new ArrayList<>();
 MautantServiceImpl(){
     constant.add("AAAA");
     constant.add("TTTT");
     constant.add("CCCC");
     constant.add("GGGG");
 }


    @Override
    public boolean isMutantservice(String[] dna){

        List<String> dnaAll= new ArrayList<>();
        List<String> diagonal1= new ArrayList<>();
        List<String> diagonal2= new ArrayList<>();

        for(int i = 0 ; i < dna.length ; i++) {
            int finalI = i ;
            List<String> tmp;
            String result = Stream.of(dna).
                    map(x -> List.of(x.split(""))).collect(Collectors.toList()).
                    stream().map(x -> x.get(finalI)).map(String::valueOf).collect(Collectors.joining());
            dnaAll.add(dna[i]);
            dnaAll.add(result);

            diagonal1.add(List.of(dna[i].split("")).get(i));
            tmp=List.of(dna[i].split(""));
            diagonal2.add(tmp.get(tmp.size() - i-1 ));
        }
        dnaAll.add(diagonal2.stream().map(String::valueOf).collect(Collectors.joining()));
        dnaAll.add(diagonal2.stream().map(String::valueOf).collect(Collectors.joining()));

        System.out.println( dnaAll.size());
        String[] result = null;
        result = dnaAll.stream().filter(s -> constant.stream().anyMatch(a -> s.contains(a)))
                .collect(Collectors.toSet()).toArray(new String[0]);
        Stream.of(result).forEach(System.out::println);

        return result.length >= 1;
    }


}

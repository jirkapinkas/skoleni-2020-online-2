/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.jenkov;

import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@Warmup(iterations = 1, time = 32, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
public class MyBenchmark {

    // http://tutorials.jenkov.com/java-performance/jmh.html

    // # Warmup Iteration   2: 822.536 ops/s
//    @Benchmark
//    public void testStringCycle1() {
//        String string = "";
//        for (int i = 0; i < 1000; i++) {
//            string += i;
//        }
//    }

    // # Warmup Iteration   2: 36366.849 ops/s
//    @Benchmark
//    public void testStringCycle2() {
//        StringBuilder string = new StringBuilder();
//        for (int i = 0; i < 1000; i++) {
//            string.append(i);
//        }
//    }

    @Param({"1", "100", "1000"})
    int p;

    @Param({"1000"})
    int max;

    HashMap<String, Set<String>> bindings = null;


    @Setup
    public void init() {
        bindings = new HashMap<>();
        for (int i = max; i >= 0; i--) {
            bindings.put("association" + i + ".association2.propertyInAssociation2", new HashSet<>());
            bindings.get("association" + i + ".association2.propertyInAssociation2").add("property1");
            bindings.get("association" + i + ".association2.propertyInAssociation2").add("property2");
            bindings.get("association" + i + ".association2.propertyInAssociation2").add("property3");

            bindings.put("association" + i + ".association2.association3.propertyInAssociation3", new HashSet<>());
            bindings.get("association" + i + ".association2.association3.propertyInAssociation3").add("property4");
            bindings.get("association" + i + ".association2.association3.propertyInAssociation3").add("property5");
            bindings.get("association" + i + ".association2.association3.propertyInAssociation3").add("property6");
            bindings.get("association" + i + ".association2.association3.propertyInAssociation3").add("property7");
        }

    }

    // Iteration   1: 0.017 ops/ms
    // Iteration   2: 0.288 ops/ms
    // Iteration   2: 4.203 ops/ms
    @Benchmark
    public void test1() {
        String path = "association" + p + ".association2.association3";

        List<Map.Entry<String, Set<String>>> result = bindings.entrySet().stream()
                .filter(e -> e.getKey().contains(path))
                .collect(Collectors.toList());

    }

    // Iteration   2: 0.099 ops/ms
    // Iteration   2: 1.268 ops/ms
    // Iteration   1: 8.026 ops/ms
//    @Benchmark
//    public void test2() {
//        String path = "association" + p + ".association2.association3";
//
//        List<Map.Entry<String, Set<String>>> result = bindings.entrySet().stream()
//                .parallel()
//                .filter(e -> e.getKey().contains(path))
//                .collect(Collectors.toList());
//
//    }


}

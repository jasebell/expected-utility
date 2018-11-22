# nm.utility.core

A compact Clojure library to calcuate expected utility. 

*Expected utility: You multiply the probability of winning by the potential gains and multiply the probability of losing by the potential losses. Adding the two gives you the expected utility of the gamble.*

The concept was originated by John von Neumann and Oskar Morgenstern and is explained in the book [The Theory of Games and Economic Behavior](https://amzn.to/2TzoSzH).

## Rationale

Expected utility can be used in decision making on whether, or not, to make a gamble on the probability of an outcome happening.

![Expected Utility](https://dataissexy.files.wordpress.com/2018/11/20181121_133546.jpg?w=529&h=382)

## Usage

The library is available on Clojars. So you can add it to your `project.clj` file. 

`[nm.utility.core "0.1.0-SNAPSHOT"]`

Or with Maven:

```
<dependency>
  <groupId>nm.utility.core</groupId>
  <artifactId>nm.utility.core</artifactId>
  <version>0.1.0-SNAPSHOT</version>
</dependency>
```

Once installed the library is very straightforward to use. It only requires three variables. 

* The potential gain if the outcome happens.
* The potential loss if the outcome doesn't happen.
* The chance (probility) of the outcome happening.

The function call is `(expected-utility gain loss probability-percent)`. A map will be returned with the outcome and if expected utility is greater than the status quo (zero) then the `:execute-decision` key will be true. 

```
user> (require '[nm.utility.core :as nm])

user> (nm/expected-utility 80 10 12.5)

user> {:gain-utility 10.0, :loss-utility 8.75, :gain-probability 0.125, :chance-of-loss 0.875, :expected-utility 1.25, :execute-descion true}

user> (clojure.pprint/pprint *1)
{:gain-utility 10.0,
 :loss-utility 8.75,
 :gain-probability 0.125,
 :chance-of-loss 0.875,
 :expected-utility 1.25,
 :execute-descion true}
```

## License

Copyright © 2018 Jason Bell

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

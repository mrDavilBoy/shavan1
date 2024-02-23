import pandas as pd
from mlxtend.frequent_patterns import apriori, association_rules
from mlxtend.preprocessing import TransactionEncoder

transactions = [['Bread','Milk'],
                ['Bread','Diaper','Beer','Eggs'],
                ['Milk','Diaper','Beer','Coke'],
                ['Bread','Milk','Diaper','Beer'],
                ['Bread','Milk','Diaper','Coke']]

te = TransactionEncoder()
te_array=te.fit(transactions).transform(transactions)
df = pd.DataFrame(te_array, columns=te.columns_)
print(df)

freq_items = apriori(df,min_support =0.8, use_colnames=True)
print("\n\nFREQUENT ITEMSETS\n\n")
print(freq_items)

rules = association_rules(freq_items, metric='support', min_threshold=0.05)
print("\n\nMining Association Rules\n\n")
rules = rules.sort_values(['support','confidence'],ascending=[False,False])
print(rules)

'''
#Min Support = 0.3

ty56@pc16:~/ty56/ty_DA_56/Assignment 2$ python3 seta1.py
    Beer  Bread   Coke  Diaper   Eggs   Milk
0  False   True  False   False  False   True
1   True   True  False    True   True  False
2   True  False   True    True  False   True
3   True   True  False    True  False   True
4  False   True   True    True  False   True


FREQUENT ITEMSETS


    support               itemsets
0       0.6                 (Beer)
1       0.8                (Bread)
2       0.4                 (Coke)
3       0.8               (Diaper)
4       0.8                 (Milk)
5       0.4          (Beer, Bread)
6       0.6         (Beer, Diaper)
7       0.4           (Beer, Milk)
8       0.6        (Diaper, Bread)
9       0.6          (Milk, Bread)
10      0.4         (Diaper, Coke)
11      0.4           (Coke, Milk)
12      0.6         (Diaper, Milk)
13      0.4  (Beer, Diaper, Bread)
14      0.4   (Beer, Diaper, Milk)
15      0.4  (Diaper, Milk, Bread)
16      0.4   (Diaper, Coke, Milk)


Mining Association Rules


        antecedents      consequents  antecedent support  consequent support  support  confidence      lift  leverage  conviction
2            (Beer)         (Diaper)                 0.6                 0.8      0.6    1.000000  1.250000      0.12         inf
3          (Diaper)           (Beer)                 0.8                 0.6      0.6    0.750000  1.250000      0.12         1.6
6          (Diaper)          (Bread)                 0.8                 0.8      0.6    0.750000  0.937500     -0.04         0.8
7           (Bread)         (Diaper)                 0.8                 0.8      0.6    0.750000  0.937500     -0.04         0.8
8            (Milk)          (Bread)                 0.8                 0.8      0.6    0.750000  0.937500     -0.04         0.8
9           (Bread)           (Milk)                 0.8                 0.8      0.6    0.750000  0.937500     -0.04         0.8
14         (Diaper)           (Milk)                 0.8                 0.8      0.6    0.750000  0.937500     -0.04         0.8
15           (Milk)         (Diaper)                 0.8                 0.8      0.6    0.750000  0.937500     -0.04         0.8
11           (Coke)         (Diaper)                 0.4                 0.8      0.4    1.000000  1.250000      0.08         inf
12           (Coke)           (Milk)                 0.4                 0.8      0.4    1.000000  1.250000      0.08         inf
17    (Beer, Bread)         (Diaper)                 0.4                 0.8      0.4    1.000000  1.250000      0.08         inf
23     (Beer, Milk)         (Diaper)                 0.4                 0.8      0.4    1.000000  1.250000      0.08         inf
34   (Diaper, Coke)           (Milk)                 0.4                 0.8      0.4    1.000000  1.250000      0.08         inf
36     (Coke, Milk)         (Diaper)                 0.4                 0.8      0.4    1.000000  1.250000      0.08         inf
38           (Coke)   (Diaper, Milk)                 0.4                 0.6      0.4    1.000000  1.666667      0.16         inf
0            (Beer)          (Bread)                 0.6                 0.8      0.4    0.666667  0.833333     -0.08         0.6
4            (Beer)           (Milk)                 0.6                 0.8      0.4    0.666667  0.833333     -0.08         0.6
16   (Beer, Diaper)          (Bread)                 0.6                 0.8      0.4    0.666667  0.833333     -0.08         0.6
18  (Diaper, Bread)           (Beer)                 0.6                 0.6      0.4    0.666667  1.111111      0.04         1.2
19           (Beer)  (Diaper, Bread)                 0.6                 0.6      0.4    0.666667  1.111111      0.04         1.2
22   (Beer, Diaper)           (Milk)                 0.6                 0.8      0.4    0.666667  0.833333     -0.08         0.6
24   (Diaper, Milk)           (Beer)                 0.6                 0.6      0.4    0.666667  1.111111      0.04         1.2
25           (Beer)   (Diaper, Milk)                 0.6                 0.6      0.4    0.666667  1.111111      0.04         1.2
28   (Diaper, Milk)          (Bread)                 0.6                 0.8      0.4    0.666667  0.833333     -0.08         0.6
29  (Diaper, Bread)           (Milk)                 0.6                 0.8      0.4    0.666667  0.833333     -0.08         0.6
30    (Bread, Milk)         (Diaper)                 0.6                 0.8      0.4    0.666667  0.833333     -0.08         0.6
35   (Diaper, Milk)           (Coke)                 0.6                 0.4      0.4    0.666667  1.666667      0.16         1.8
1           (Bread)           (Beer)                 0.8                 0.6      0.4    0.500000  0.833333     -0.08         0.8
5            (Milk)           (Beer)                 0.8                 0.6      0.4    0.500000  0.833333     -0.08         0.8
10         (Diaper)           (Coke)                 0.8                 0.4      0.4    0.500000  1.250000      0.08         1.2
13           (Milk)           (Coke)                 0.8                 0.4      0.4    0.500000  1.250000      0.08         1.2
20         (Diaper)    (Beer, Bread)                 0.8                 0.4      0.4    0.500000  1.250000      0.08         1.2
21          (Bread)   (Beer, Diaper)                 0.8                 0.6      0.4    0.500000  0.833333     -0.08         0.8
26         (Diaper)     (Beer, Milk)                 0.8                 0.4      0.4    0.500000  1.250000      0.08         1.2
27           (Milk)   (Beer, Diaper)                 0.8                 0.6      0.4    0.500000  0.833333     -0.08         0.8
31         (Diaper)    (Bread, Milk)                 0.8                 0.6      0.4    0.500000  0.833333     -0.08         0.8
32           (Milk)  (Diaper, Bread)                 0.8                 0.6      0.4    0.500000  0.833333     -0.08         0.8
33          (Bread)   (Diaper, Milk)                 0.8                 0.6      0.4    0.500000  0.833333     -0.08         0.8
37         (Diaper)     (Coke, Milk)                 0.8                 0.4      0.4    0.500000  1.250000      0.08         1.2
39           (Milk)   (Diaper, Coke)                 0.8                 0.4      0.4    0.500000  1.250000      0.08         1.2


#Minimum Support 0.5

ty56@pc16:~/ty56/ty_DA_56/Assignment 2$ python3 seta1.py
    Beer  Bread   Coke  Diaper   Eggs   Milk
0  False   True  False   False  False   True
1   True   True  False    True   True  False
2   True  False   True    True  False   True
3   True   True  False    True  False   True
4  False   True   True    True  False   True


FREQUENT ITEMSETS


   support         itemsets
0      0.6           (Beer)
1      0.8          (Bread)
2      0.8         (Diaper)
3      0.8           (Milk)
4      0.6   (Diaper, Beer)
5      0.6  (Bread, Diaper)
6      0.6    (Milk, Bread)
7      0.6   (Milk, Diaper)


Mining Association Rules


  antecedents consequents  antecedent support  consequent support  support  confidence    lift  leverage  conviction
1      (Beer)    (Diaper)                 0.6                 0.8      0.6        1.00  1.2500      0.12         inf
0    (Diaper)      (Beer)                 0.8                 0.6      0.6        0.75  1.2500      0.12         1.6
2     (Bread)    (Diaper)                 0.8                 0.8      0.6        0.75  0.9375     -0.04         0.8
3    (Diaper)     (Bread)                 0.8                 0.8      0.6        0.75  0.9375     -0.04         0.8
4      (Milk)     (Bread)                 0.8                 0.8      0.6        0.75  0.9375     -0.04         0.8
5     (Bread)      (Milk)                 0.8                 0.8      0.6        0.75  0.9375     -0.04         0.8
6      (Milk)    (Diaper)                 0.8                 0.8      0.6        0.75  0.9375     -0.04         0.8
7    (Diaper)      (Milk)                 0.8                 0.8      0.6        0.75  0.9375     -0.04         0.8



Min Support = 0.8

ty56@pc16:~/ty56/ty_DA_56/Assignment 2$ python3 seta1.py
    Beer  Bread   Coke  Diaper   Eggs   Milk
0  False   True  False   False  False   True
1   True   True  False    True   True  False
2   True  False   True    True  False   True
3   True   True  False    True  False   True
4  False   True   True    True  False   True


FREQUENT ITEMSETS


   support  itemsets
0      0.8   (Bread)
1      0.8  (Diaper)
2      0.8    (Milk)


Mining Association Rules


Empty DataFrame
Columns: [antecedents, consequents, antecedent support, consequent support, support, confidence, lift, leverage, conviction]
Index: []


'''

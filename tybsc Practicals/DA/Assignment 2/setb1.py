import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

df = pd.read_csv('Market_Basket_Optimisation.csv')
print(df)
df = df.dropna()
transactions = []
for i in range(0, len(df)):
    transactions.append([str(df.values[i,j]) for j in range(0, len(df.columns))])
    
from apyori import apriori
rules = apriori(transactions, min_support = 0.003, min_confidence = 0.2, min_lift = 3, min_length = 2)

results = list(rules)

import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
import numpy as np
from sklearn.linear_model import LinearRegression
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from sklearn import metrics
'''
#Q1
df = pd.read_csv("advertising.csv")
X = df.iloc[:,[0,1,2]].values
y = df.iloc[:,[3]].values
X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.3,random_state=0)

regressor = LinearRegression()
regressor.fit(X_train,y_train)
y_pred = regressor.predict(X_test)
print(y_pred)
print("Predicted Values are : \n",y_pred)
print("Actual Values are : \n",y_test)

'''
#Q2
df = pd.read_csv("Real estate.csv")
X = df.iloc[:,[0,1,2]].values
y = df.iloc[:,[3]].values
X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.2,random_state=0)

regressor = LinearRegression()
regressor.fit(X_train,y_train)
y_pred = regressor.predict(X_test)
print("Predicted Values are : \n",y_pred)
print("Actual Values are : \n",y_test)
'''
#Q3
df = pd.read_csv("User_Data.csv")
X = df.iloc[:,[0,2,3]].values
y = df.iloc[:,[4]].values
X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.3,random_state=0)

regressor = LogisticRegression()
regressor.fit(X_train,y_train)
y_pred = regressor.predict(X_test)
print("Predicted Values are : \n",y_pred)
print("Actual Values are : \n",y_test)

'''

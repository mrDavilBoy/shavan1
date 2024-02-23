import pandas as pd
import seaborn as sns
import matplotlib.pyplot as plt
import numpy as np
from sklearn.linear_model import LinearRegression
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
from sklearn import metrics
from sklearn.metrics import accuracy_score
#Q1
df = pd.read_csv("Fish.csv")
X = df.iloc[:,[2,3,4,5,6]].values
y = df.iloc[:,[1]].values
X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.3,random_state=0)

regressor = LinearRegression()
regressor.fit(X_train,y_train)
y_pred = regressor.predict(X_test)
print("Predicted Values are : \n",y_pred)
print("Actual Values are : \n",y_test)
'''

#Q2
df = pd.read_csv("Iris.csv")
print(df)
#df.columns = ['SepalLengthCm','SepalWidthCm','PetalLengthCm','PetalWidthCm','Species']

setosa = df[df['Species']=='Iris-setosa']
print("Statistics for Iris-setosa")
print(setosa.describe())

versicolor = df[df['Species']=='Iris-versicolor']
print("Statistics for Iris-versicolor")
print(versicolor.describe())

virginica = df[df['Species']=='Iris-virginica']
print("Statistics for Iris-virginica")
print(virginica.describe())

X=df.iloc[:,:-1].values
y=df.iloc[:,-1].values


X_train,X_test,y_train,y_test = train_test_split(X,y,test_size=0.3,random_state=0)

model = LogisticRegression()
model.fit(X_train,y_train)

y_pred = model.predict(X_test)

accuracy = accuracy_score(y_test,y_pred)
print("Accuracy",accuracy)
'''

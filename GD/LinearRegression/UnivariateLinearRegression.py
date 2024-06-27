import numpy as np
import matplotlib.pyplot as plt
import pandas as pd 

from linear_regression import LinearRegression

data = pd.read_csv('c:/Users/Seren/Desktop/gradient_descent/carproject/GD/data/data.csv')

train_data = data.sample(frac=0.8, random_state=200)
test_data = data.drop(train_data.index)

input_param_name = 'x' #
output_param_name = 'y' #

x_train = train_data[input_param_name].values.reshape(-1,1)
y_train = train_data[output_param_name].values.reshape(-1,1)

x_test = test_data[input_param_name].values.reshape(-1,1)
y_test = test_data[output_param_name].values.reshape(-1,1)

plt.scatter(x_train,y_train,label='Training Data')
plt.scatter(x_test,y_test,label='Testing Data')
plt.xlabel(input_param_name)
plt.ylabel(output_param_name)
plt.title('Data')
plt.legend()
plt.show()

num_iterations = 1000
alpha = 0.01

LinearRegressionModel = LinearRegression(x_train,y_train)
(theta,cost_history) = linear_regression.train(alpha,num_iterations)

print('开始时损失',cost_history[0])
print('结束时损失',cost_history[-1])

#loss值画图
plt.plot(range(1,num_iterations+1),cost_history)
plt.xlabel('迭代次数')
plt.ylabel('损失')
plt.title('线性回归')
plt.show()
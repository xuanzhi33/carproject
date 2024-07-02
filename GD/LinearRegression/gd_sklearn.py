import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import SGDRegressor, LinearRegression
from sklearn.model_selection import train_test_split
import csv

x_values = []
y_values = []
with open('./GD/data/data.csv', 'r') as f:
    reader = csv.DictReader(f)
    for row in reader:
        x_values.append(float(row['x']))
        y_values.append(float(row['y']))

x = np.array(x_values).reshape(-1, 1)
y = np.array(y_values)
x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=0.2, random_state=42)

# 使用梯度下降
sgd_regressor = SGDRegressor()
sgd_regressor.fit(x_train, y_train)
y_pred_sgd = sgd_regressor.predict(x)
y_test_pred_sgd = sgd_regressor.predict(x_test)

# 绘制结果
plt.scatter(x, y, color='black', label='Data')
plt.plot(x, y_pred_sgd, color='blue', label='SGD Regression')
# 绘制测试集
plt.scatter(x_test, y_test_pred_sgd, color='red', label='Test Data')
# 绘制测试集的正确结果
plt.scatter(x_test, y_test, color='green', label='Test Data (True)')
plt.legend()
plt.show()

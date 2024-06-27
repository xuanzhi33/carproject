import numpy as np
# from utils.features import prepare_for_training

class LinearRegression:
    def __init__(self,data,labels,polynomial_degree = 0,sinusoid_degree = 0,normalize_data = 0):
        (data_processed, features_mean, features_deviation) = prepare_for_training(data,polynomial_degree = 0,sinusoid_degree = 0,normalize_data = 0)
        
        #data_processed = 处理后的数据； features_mean = 数据均值； features_deviation = 数据标准差

        self.data = data_processed
        self.labels = labels
        self.features_mean = features_mean
        self.features_deviation = features_deviation
        self.polynomial_degree = polynomial_degree
        self.sinusoid_degree = sinusoid_degree
        self.normalize_data = normalize_data

        num_features = data_processed.shape[1]
        self.theta = np.zeros((num_features,1))

    def train(self,alpha,num_iterations = 1000):
        pass
    def gradient_descent(self,alpha,num_iterations):
        m = self.data.shape[0]
        for i in range(num_iterations):
            predictions = np.dot(self.data,self.theta)
            self.theta = self.theta - alpha*(1/m)*np.dot(self.data.T,predictions - self.labels)
    
    def gradient_step(self,alpha):
        m = self.data.shape[0]
        predictions = np.dot(self.data,self.theta)
        self.theta = self.theta - alpha*(1/m)*np.dot(self.data.T,predictions - self.labels)
            


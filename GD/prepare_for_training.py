import nummpy as np
from .normalize import normalize
from .generate_polynomials import generate_polynomials
from .generate_sinusoids import generate_sinusoids

def prepare_for_training(data, input_param_name, output_param_name, degree, num_sinusoids):
    train_data = data.sample(frac=0.8, random_state=200)
    test_data = data.drop(train_data.index)
    
    x_train = train_data[input_param_name].values.reshape(-1,1)
    y_train = train_data[output_param_name].values.reshape(-1,1)
    
    x_test = test_data[input_param_name].values.reshape(-1,1)
    y_test = test_data[output_param_name].values.reshape(-1,1)
    
    x_train_normalized, mean_of_x, std_of_x = normalize(x_train)
    y_train_normalized, mean_of_y, std_of_y = normalize(y_train)
    
    x_train_normalized = generate_polynomials(x_train_normalized, degree)
    x_train_normalized = generate_sinusoids(x_train_normalized, num_sinusoids)
    
    x_test_normalized = (x_test - mean_of_x) / std_of_x
    x_test_normalized = generate_polynomials(x_test_normalized, degree)
    x_test_normalized = generate_sinusoids(x_test_normalized, num_sinusoids)
    
    return x_train_normalized, y_train_normalized, x_test_normalized, y_test, mean_of_x, std_of_x, mean_of_y, std_of_y
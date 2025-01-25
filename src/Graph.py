import pandas as pd
import matplotlib.pyplot as plt

# Load the data
data = pd.read_csv('fibonacci_data.csv')

# Plot the Fibonacci number vs time
plt.figure(figsize=(10, 6))
plt.plot(data['Time Since Start (ms)'], data['Fibonacci Number'])
plt.title('Fibonacci Numbers Over Time')
plt.xlabel('Time Since Start (ms)')
plt.ylabel('Fibonacci Number')
plt.yscale('log')  # Use logarithmic scale due to exponential growth
plt.grid(True)
plt.show()

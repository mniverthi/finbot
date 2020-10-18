from alpha_vantage.timeseries import TimeSeries
import matplotlib.pyplot as plt
ts = TimeSeries(key='081KCSSOXHL4CEGC',output_format='pandas')
data, meta_data = ts.get_intraday(symbol='TSLA',interval='1min', outputsize='full')
print(data)
data['4. close'].plot()
plt.title('Intraday TimeSeries')
plt.show()

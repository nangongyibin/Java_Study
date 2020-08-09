x = 0:0.25:12
y1 = x.^2;
y2 = 12 - x;
plot(x,y1,x,y2)
xlabel('x');
ylabel('y');
legend('y1=x^2','y2=12-x');
title('ªÊ÷∆');
axis([0 15 0 15]);
text(3,9,'Ωªµ„');
grid on
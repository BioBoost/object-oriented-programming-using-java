Note that this approach is more biased and less efficient than a nextInt approach, https://stackoverflow.com/a/738651/360211

One standard pattern for accomplishing this is:

Min + (int)(Math.random() * ((Max - Min) + 1))
The Java Math library function Math.random() generates a double value in the range [0,1). Notice this range does not include the 1.

In order to get a specific range of values first, you need to multiply by the magnitude of the range of values you want covered.

Math.random() * ( Max - Min )
This returns a value in the range [0,Max-Min), where 'Max-Min' is not included.

For example, if you want [5,10), you need to cover five integer values so you use

Math.random() * 5
This would return a value in the range [0,5), where 5 is not included.

Now you need to shift this range up to the range that you are targeting. You do this by adding the Min value.

Min + (Math.random() * (Max - Min))
You now will get a value in the range [Min,Max). Following our example, that means [5,10):

5 + (Math.random() * (10 - 5))
But, this still doesn't include Max and you are getting a double value. In order to get the Max value included, you need to add 1 to your range parameter (Max - Min) and then truncate the decimal part by casting to an int. This is accomplished via:

Min + (int)(Math.random() * ((Max - Min) + 1))
And there you have it. A random integer value in the range [Min,Max], or per the example [5,10]:

5 + (int)(Math.random() * ((10 - 5) + 1))
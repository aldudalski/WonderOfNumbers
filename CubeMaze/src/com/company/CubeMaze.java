package com.company;

/**
 * Created by alek.zdziarski on 3/7/2015.
 */
public class CubeMaze {

    // not a pretty implementation but very easy to generate out of the structure excel
    NumberBubble startingBubble;
    NumberBubble endingBubble;

    // Create cube bubbles
    NumberBubble i1= new NumberBubble(1);
    NumberBubble i2= new NumberBubble(2);
    NumberBubble i3= new NumberBubble(3);
    NumberBubble i4= new NumberBubble(4);
    NumberBubble i5= new NumberBubble(5);
    NumberBubble i6= new NumberBubble(6);
    NumberBubble i7= new NumberBubble(7);
    NumberBubble i8= new NumberBubble(8);
    NumberBubble i9= new NumberBubble(9);
    NumberBubble i10= new NumberBubble(10);
    NumberBubble i11= new NumberBubble(11);
    NumberBubble i12= new NumberBubble(12);
    NumberBubble i13= new NumberBubble(13);
    NumberBubble i14= new NumberBubble(14);
    NumberBubble i15= new NumberBubble(15);
    NumberBubble i16= new NumberBubble(16);
    NumberBubble i17= new NumberBubble(17);
    NumberBubble i18= new NumberBubble(18);
    NumberBubble i19= new NumberBubble(19);
    NumberBubble i20= new NumberBubble(20);
    NumberBubble i21= new NumberBubble(21);
    NumberBubble i22= new NumberBubble(22);
    NumberBubble i23= new NumberBubble(23);
    NumberBubble i24= new NumberBubble(24);
    NumberBubble i25= new NumberBubble(25);
    NumberBubble i26= new NumberBubble(26);
    NumberBubble i27= new NumberBubble(27);

    public CubeMaze(){

        //arrange bubbles interconnections
        i1.addConnection(i10);	i1.addConnection(i4);	i1.addConnection(i2);
        i2.addConnection(i3);	i2.addConnection(i11);	i2.addConnection(i5);	i2.addConnection(i1);
        i3.addConnection(i12);	i3.addConnection(i2);	i3.addConnection(i6);
        i4.addConnection(i1);	i4.addConnection(i7);	i4.addConnection(i13);	i4.addConnection(i5);
        i5.addConnection(i14);	i5.addConnection(i6);	i5.addConnection(i4);	i5.addConnection(i8);	i5.addConnection(i2);
        i6.addConnection(i15);	i6.addConnection(i3);	i6.addConnection(i9);	i6.addConnection(i5);
        i7.addConnection(i16);	i7.addConnection(i8);	i7.addConnection(i4);
        i8.addConnection(i9);	i8.addConnection(i7);	i8.addConnection(i17);	i8.addConnection(i5);
        i9.addConnection(i18);	i9.addConnection(i8);	i9.addConnection(i6);
        i10.addConnection(i19);	i10.addConnection(i11);	i10.addConnection(i1);	i10.addConnection(i13);
        i11.addConnection(i20);	i11.addConnection(i12);	i11.addConnection(i10);	i11.addConnection(i14);	i11.addConnection(i2);
        i12.addConnection(i21);	i12.addConnection(i3);	i12.addConnection(i11);	i12.addConnection(i15);
        i13.addConnection(i22);	i13.addConnection(i10);	i13.addConnection(i4);	i13.addConnection(i14);	i13.addConnection(i16);
        i14.addConnection(i23);	i14.addConnection(i5);	i14.addConnection(i11);	i14.addConnection(i17);	i14.addConnection(i15);	i14.addConnection(i13);
        i15.addConnection(i24);	i15.addConnection(i12);	i15.addConnection(i18);	i15.addConnection(i6);	i15.addConnection(i14);
        i16.addConnection(i7);	i16.addConnection(i25);	i16.addConnection(i17);	i16.addConnection(i13);
        i17.addConnection(i14);	i17.addConnection(i16);	i17.addConnection(i18);	i17.addConnection(i8);	i17.addConnection(i26);
        i18.addConnection(i27);	i18.addConnection(i15);	i18.addConnection(i17);	i18.addConnection(i9);
        i19.addConnection(i20);	i19.addConnection(i22);	i19.addConnection(i10);
        i20.addConnection(i21);	i20.addConnection(i11);	i20.addConnection(i23);	i20.addConnection(i19);
        i21.addConnection(i20);	i21.addConnection(i12);	i21.addConnection(i24);
        i22.addConnection(i19);	i22.addConnection(i23);	i22.addConnection(i25);	i22.addConnection(i13);
        i23.addConnection(i24);	i23.addConnection(i20);	i23.addConnection(i22);	i23.addConnection(i26);	i23.addConnection(i14);
        i24.addConnection(i21);	i24.addConnection(i23);	i24.addConnection(i27);	i24.addConnection(i15);
        i25.addConnection(i16);	i25.addConnection(i26);	i25.addConnection(i22);
        i26.addConnection(i23);	i26.addConnection(i27);	i26.addConnection(i25);	i26.addConnection(i17);
        i27.addConnection(i24);	i27.addConnection(i26);	i27.addConnection(i18);

        //Set starting and ending bubble
        startingBubble = i21;
        startingBubble.setStartingBubble();

        //Set ending bubble
        endingBubble = i3;
        endingBubble.setEndingBubble();
    }

    public NumberBubble getStartingBubbleInMaze(){
        return startingBubble;
    }
}

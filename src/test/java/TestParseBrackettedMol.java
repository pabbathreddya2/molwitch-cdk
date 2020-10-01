/*
 * NCATS-MOLWITCH-CDK
 *
 * Copyright (c) 2020.
 *
 * This work is free software; you can redistribute it and/or modify it under the terms of the
 * GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This work is distributed in the hope that it will be useful, but without any warranty;
 * without even the implied warranty of merchantability or fitness for a particular purpose.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this library;
 *  if not, write to:
 *
 *  the Free Software Foundation, Inc.
 *  59 Temple Place, Suite 330
 *  Boston, MA 02111-1307 USA
 */

import gov.nih.ncats.molwitch.Chemical;
import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.*;

public class TestParseBrackettedMol {

    @Test
    public void parse() throws IOException {

        String mol= "\n" +
                "  Marvin  02272022332D          \n" +
                "\n" +
                "209194  0  0  1  0            999 V2000\n" +
                "   17.9342   -8.6644    0.0000 Ca  0  2  0  0  0  0  0  0  0  0  0  0\n" +
                "   15.1510    2.1387    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   14.7490    1.4044    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   13.9256    1.4044    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   13.5040    2.1113    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   13.5234    0.6861    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   12.6999    0.6861    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   12.2980   -0.0483    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   11.4745   -0.0483    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   11.0724   -0.7828    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   10.2489   -0.7828    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    9.8469   -1.5123    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    9.0186   -1.5123    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    8.6214   -2.2467    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    9.0430   -2.9536    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.7930   -2.2467    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.3959   -2.9762    0.0000 C   0  0  2  0  0  0  0  0  0  0  0  0\n" +
                "    7.8176   -3.6880    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    8.6410   -3.6880    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.4155   -4.4062    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.8371   -5.1132    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "    8.6606   -5.1132    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    9.0871   -5.8090    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    9.9106   -5.8090    0.0000 O   0  5  0  0  0  0  0  0  0  0  0  0\n" +
                "    8.6851   -6.5320    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    9.1397   -4.2912    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.4352   -5.8364    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.8616   -6.5433    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.6117   -5.8364    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.2096   -6.5660    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "    5.3861   -6.5660    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    4.9646   -5.8703    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    4.1361   -5.8703    0.0000 O   0  5  0  0  0  0  0  0  0  0  0  0\n" +
                "    5.3665   -5.1521    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.6312   -7.2729    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.4595   -7.2729    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.2341   -7.9959    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.6556   -8.7028    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.2535   -9.4212    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    5.4302   -9.4212    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.6752  -10.1328    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.2733  -10.8512    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "    6.6996  -11.5469    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.5232  -11.5469    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.9250  -10.8286    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.9446  -12.2538    0.0000 O   0  5  0  0  0  0  0  0  0  0  0  0\n" +
                "    5.4498  -10.8512    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    5.0282  -10.1555    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    5.0478  -11.5856    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    4.2243  -11.5856    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.8223  -12.3152    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    4.2438  -13.0222    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.9987  -12.3152    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.5966  -13.0494    0.0000 C   0  0  2  0  0  0  0  0  0  0  0  0\n" +
                "    1.7731  -13.0494    0.0000 C   0  0  2  0  0  0  0  0  0  0  0  0\n" +
                "    1.3711  -13.7790    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    1.3466  -12.3538    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.0182  -13.7565    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.8417  -13.7565    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.6163  -14.4747    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.0426  -15.1864    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "    3.8663  -15.1864    0.0000 C   0  0  2  0  0  0  0  0  0  0  0  0\n" +
                "    4.2681  -14.4521    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    4.2877  -15.8821    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.6407  -15.9047    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    1.8125  -15.9047    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.0622  -16.6118    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.8828  -16.6891    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    4.0656  -17.4890    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.3588  -17.9154    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.7361  -17.3697    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "    1.9316  -17.5524    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    1.3738  -16.9500    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    1.6892  -18.3424    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    0.8847  -18.8760    0.0000 C   0  0  2  0  0  0  0  0  0  0  0  0\n" +
                "    0.7591  -20.2099    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "    1.5812  -20.6842    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    1.5812  -21.6375    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    0.7591  -22.1117    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "   -0.2275  -21.6657    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   -0.2275  -20.5883    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   -1.0495  -22.1400    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    0.7591  -23.0602    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    1.5812  -23.5344    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.4080  -23.0602    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.4080  -22.1117    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    0.0898  -22.7857    0.0000 H   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.4080  -20.2099    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   -0.0631  -19.7358    0.0000 H   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    0.0627  -18.4019    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.7361  -18.3229    0.0000 H   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.1874  -10.1328    0.0000 H   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.5676   -2.9762    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.1461   -2.2806    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    5.3224   -2.2806    0.0000 O   0  5  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.5479   -1.5624    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   -4.6391   -7.2187    0.0000 H   0  3  0  0  0  0  0  0  0  0  0  0\n" +
                "   17.9342   -8.6644    0.0000 Ca  0  2  0  0  0  0  0  0  0  0  0  0\n" +
                "   17.9342   -8.6644    0.0000 Ca  0  2  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   18.8799   -2.0762    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   15.1510    2.1387    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   14.7490    1.4044    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   13.9256    1.4044    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   13.5040    2.1113    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   13.5234    0.6861    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   12.6999    0.6861    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   12.2980   -0.0483    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   11.4745   -0.0483    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   11.0724   -0.7828    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   10.2489   -0.7828    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    9.8469   -1.5123    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    9.0186   -1.5123    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    8.6214   -2.2467    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    9.0430   -2.9536    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.7930   -2.2467    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.3959   -2.9762    0.0000 C   0  0  2  0  0  0  0  0  0  0  0  0\n" +
                "    7.8176   -3.6880    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    8.6410   -3.6880    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.4155   -4.4062    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.8371   -5.1132    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "    8.6606   -5.1132    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    9.0871   -5.8090    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    9.9106   -5.8090    0.0000 O   0  5  0  0  0  0  0  0  0  0  0  0\n" +
                "    8.6851   -6.5320    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    9.1397   -4.2912    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.4352   -5.8364    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.8616   -6.5433    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.6117   -5.8364    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.2096   -6.5660    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "    5.3861   -6.5660    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    4.9646   -5.8703    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    4.1361   -5.8703    0.0000 O   0  5  0  0  0  0  0  0  0  0  0  0\n" +
                "    5.3665   -5.1521    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.6312   -7.2729    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.4595   -7.2729    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.2341   -7.9959    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.6556   -8.7028    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.2535   -9.4212    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    5.4302   -9.4212    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.6752  -10.1328    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.2733  -10.8512    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "    6.6996  -11.5469    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.5232  -11.5469    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.9250  -10.8286    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.9446  -12.2538    0.0000 O   0  5  0  0  0  0  0  0  0  0  0  0\n" +
                "    5.4498  -10.8512    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    5.0282  -10.1555    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    5.0478  -11.5856    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    4.2243  -11.5856    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.8223  -12.3152    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    4.2438  -13.0222    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.9987  -12.3152    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.5966  -13.0494    0.0000 C   0  0  2  0  0  0  0  0  0  0  0  0\n" +
                "    1.7731  -13.0494    0.0000 C   0  0  2  0  0  0  0  0  0  0  0  0\n" +
                "    1.3711  -13.7790    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    1.3466  -12.3538    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.0182  -13.7565    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.8417  -13.7565    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.6163  -14.4747    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.0426  -15.1864    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "    3.8663  -15.1864    0.0000 C   0  0  2  0  0  0  0  0  0  0  0  0\n" +
                "    4.2681  -14.4521    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    4.2877  -15.8821    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.6407  -15.9047    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    1.8125  -15.9047    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.0622  -16.6118    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.8828  -16.6891    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    4.0656  -17.4890    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    3.3588  -17.9154    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.7361  -17.3697    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "    1.9316  -17.5524    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    1.3738  -16.9500    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    1.6892  -18.3424    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    0.8847  -18.8760    0.0000 C   0  0  2  0  0  0  0  0  0  0  0  0\n" +
                "    0.7591  -20.2099    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "    1.5812  -20.6842    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    1.5812  -21.6375    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    0.7591  -22.1117    0.0000 C   0  0  1  0  0  0  0  0  0  0  0  0\n" +
                "   -0.2275  -21.6657    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   -0.2275  -20.5883    0.0000 N   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   -1.0495  -22.1400    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    0.7591  -23.0602    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    1.5812  -23.5344    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.4080  -23.0602    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.4080  -22.1117    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    0.0898  -22.7857    0.0000 H   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.4080  -20.2099    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   -0.0631  -19.7358    0.0000 H   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    0.0627  -18.4019    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    2.7361  -18.3229    0.0000 H   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    7.1874  -10.1328    0.0000 H   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.5676   -2.9762    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.1461   -2.2806    0.0000 C   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "    5.3224   -2.2806    0.0000 O   0  5  0  0  0  0  0  0  0  0  0  0\n" +
                "    6.5479   -1.5624    0.0000 O   0  0  0  0  0  0  0  0  0  0  0  0\n" +
                "   -4.6391   -7.2187    0.0000 H   0  3  0  0  0  0  0  0  0  0  0  0\n" +
                "  4  6  1  0  0  0  0\n" +
                "  6  7  1  0  0  0  0\n" +
                "  7  8  1  0  0  0  0\n" +
                "  8  9  1  0  0  0  0\n" +
                "  9 10  1  0  0  0  0\n" +
                " 10 11  1  0  0  0  0\n" +
                " 11 12  2  0  0  0  0\n" +
                " 12 13  1  0  0  0  0\n" +
                " 13 14  1  0  0  0  0\n" +
                " 14 15  2  0  0  0  0\n" +
                " 14 16  1  0  0  0  0\n" +
                " 16 17  1  0  0  0  0\n" +
                " 17 18  1  0  0  0  0\n" +
                " 18 19  2  0  0  0  0\n" +
                " 18 20  1  0  0  0  0\n" +
                " 20 21  1  0  0  0  0\n" +
                " 21 22  1  1  0  0  0\n" +
                " 22 23  1  0  0  0  0\n" +
                " 23 24  1  0  0  0  0\n" +
                " 23 25  2  0  0  0  0\n" +
                " 22 26  1  1  0  0  0\n" +
                " 21 27  1  0  0  0  0\n" +
                " 27 28  2  0  0  0  0\n" +
                " 27 29  1  0  0  0  0\n" +
                " 29 30  1  0  0  0  0\n" +
                " 30 31  1  6  0  0  0\n" +
                " 31 32  1  0  0  0  0\n" +
                " 32 33  1  0  0  0  0\n" +
                " 32 34  2  0  0  0  0\n" +
                " 30 35  1  0  0  0  0\n" +
                " 35 36  2  0  0  0  0\n" +
                " 35 37  1  0  0  0  0\n" +
                " 37 38  1  0  0  0  0\n" +
                " 38 39  1  0  0  0  0\n" +
                " 39 40  2  0  0  0  0\n" +
                " 39 41  1  0  0  0  0\n" +
                " 41 42  1  0  0  0  0\n" +
                " 42 43  1  1  0  0  0\n" +
                " 43 44  1  0  0  0  0\n" +
                " 44 45  2  0  0  0  0\n" +
                " 44 46  1  0  0  0  0\n" +
                " 42 47  1  0  0  0  0\n" +
                " 47 48  2  0  0  0  0\n" +
                " 47 49  1  0  0  0  0\n" +
                " 49 50  1  0  0  0  0\n" +
                " 50 51  1  0  0  0  0\n" +
                " 51 52  2  0  0  0  0\n" +
                " 51 53  1  0  0  0  0\n" +
                " 53 54  1  0  0  0  0\n" +
                " 54 55  1  1  0  0  0\n" +
                " 55 56  1  6  0  0  0\n" +
                " 55 57  1  0  0  0  0\n" +
                " 54 58  1  0  0  0  0\n" +
                " 58 59  2  0  0  0  0\n" +
                " 58 60  1  0  0  0  0\n" +
                " 60 61  1  0  0  0  0\n" +
                " 61 62  1  1  0  0  0\n" +
                " 62 63  1  0  0  0  0\n" +
                " 62 64  1  0  0  0  0\n" +
                " 61 65  1  0  0  0  0\n" +
                " 65 66  2  0  0  0  0\n" +
                " 65 67  1  0  0  0  0\n" +
                " 67 68  1  0  0  0  0\n" +
                " 68 69  1  0  0  0  0\n" +
                " 69 70  1  0  0  0  0\n" +
                " 70 71  1  0  0  0  0\n" +
                " 67 71  1  0  0  0  0\n" +
                " 71 72  1  0  0  0  0\n" +
                " 72 73  2  0  0  0  0\n" +
                " 72 74  1  0  0  0  0\n" +
                " 74 75  1  0  0  0  0\n" +
                " 75 76  1  0  0  0  0\n" +
                " 76 77  1  0  0  0  0\n" +
                " 77 78  1  0  0  0  0\n" +
                " 78 79  1  0  0  0  0\n" +
                " 80 79  1  0  0  0  0\n" +
                " 81 80  1  0  0  0  0\n" +
                " 76 81  1  0  0  0  0\n" +
                " 80 82  2  0  0  0  0\n" +
                " 79 83  1  0  0  0  0\n" +
                " 83 84  1  0  0  0  0\n" +
                " 84 85  1  0  0  0  0\n" +
                " 86 85  1  0  0  0  0\n" +
                " 78 86  1  0  0  0  0\n" +
                " 79 87  1  1  0  0  0\n" +
                " 77 88  2  0  0  0  0\n" +
                " 76 89  1  6  0  0  0\n" +
                " 75 90  1  6  0  0  0\n" +
                " 71 91  1  6  0  0  0\n" +
                " 41 92  1  0  0  0  0\n" +
                " 17 93  1  6  0  0  0\n" +
                " 93 94  1  0  0  0  0\n" +
                " 94 95  1  0  0  0  0\n" +
                " 94 96  2  0  0  0  0\n" +
                "  2  3  1  0  0  0  0\n" +
                "  3  4  1  0  0  0  0\n" +
                "  4  5  1  0  0  0  0\n" +
                "114115  1  0  0  0  0\n" +
                "115116  1  0  0  0  0\n" +
                "116118  1  0  0  0  0\n" +
                "116117  1  0  0  0  0\n" +
                "118119  1  0  0  0  0\n" +
                "119120  1  0  0  0  0\n" +
                "120121  1  0  0  0  0\n" +
                "121122  1  0  0  0  0\n" +
                "122123  1  0  0  0  0\n" +
                "123124  2  0  0  0  0\n" +
                "124125  1  0  0  0  0\n" +
                "125126  1  0  0  0  0\n" +
                "126127  2  0  0  0  0\n" +
                "126128  1  0  0  0  0\n" +
                "128129  1  0  0  0  0\n" +
                "129130  1  0  0  0  0\n" +
                "129205  1  6  0  0  0\n" +
                "130131  2  0  0  0  0\n" +
                "130132  1  0  0  0  0\n" +
                "132133  1  0  0  0  0\n" +
                "133134  1  1  0  0  0\n" +
                "133139  1  0  0  0  0\n" +
                "134135  1  0  0  0  0\n" +
                "134138  1  1  0  0  0\n" +
                "135136  1  0  0  0  0\n" +
                "135137  2  0  0  0  0\n" +
                "139140  2  0  0  0  0\n" +
                "139141  1  0  0  0  0\n" +
                "141142  1  0  0  0  0\n" +
                "142143  1  6  0  0  0\n" +
                "142147  1  0  0  0  0\n" +
                "143144  1  0  0  0  0\n" +
                "144145  1  0  0  0  0\n" +
                "144146  2  0  0  0  0\n" +
                "147148  2  0  0  0  0\n" +
                "147149  1  0  0  0  0\n" +
                "149150  1  0  0  0  0\n" +
                "150151  1  0  0  0  0\n" +
                "151152  2  0  0  0  0\n" +
                "151153  1  0  0  0  0\n" +
                "153154  1  0  0  0  0\n" +
                "153204  1  0  0  0  0\n" +
                "154155  1  1  0  0  0\n" +
                "154159  1  0  0  0  0\n" +
                "155156  1  0  0  0  0\n" +
                "156157  2  0  0  0  0\n" +
                "156158  1  0  0  0  0\n" +
                "159160  2  0  0  0  0\n" +
                "159161  1  0  0  0  0\n" +
                "161162  1  0  0  0  0\n" +
                "162163  1  0  0  0  0\n" +
                "163164  2  0  0  0  0\n" +
                "163165  1  0  0  0  0\n" +
                "165166  1  0  0  0  0\n" +
                "166167  1  1  0  0  0\n" +
                "166170  1  0  0  0  0\n" +
                "167168  1  6  0  0  0\n" +
                "167169  1  0  0  0  0\n" +
                "170171  2  0  0  0  0\n" +
                "170172  1  0  0  0  0\n" +
                "172173  1  0  0  0  0\n" +
                "173174  1  1  0  0  0\n" +
                "173177  1  0  0  0  0\n" +
                "174175  1  0  0  0  0\n" +
                "174176  1  0  0  0  0\n" +
                "177178  2  0  0  0  0\n" +
                "177179  1  0  0  0  0\n" +
                "179180  1  0  0  0  0\n" +
                "179183  1  0  0  0  0\n" +
                "180181  1  0  0  0  0\n" +
                "181182  1  0  0  0  0\n" +
                "182183  1  0  0  0  0\n" +
                "183184  1  0  0  0  0\n" +
                "183203  1  6  0  0  0\n" +
                "184185  2  0  0  0  0\n" +
                "184186  1  0  0  0  0\n" +
                "186187  1  0  0  0  0\n" +
                "187188  1  0  0  0  0\n" +
                "187202  1  6  0  0  0\n" +
                "188189  1  0  0  0  0\n" +
                "188193  1  0  0  0  0\n" +
                "188201  1  6  0  0  0\n" +
                "189190  1  0  0  0  0\n" +
                "189200  2  0  0  0  0\n" +
                "190191  1  0  0  0  0\n" +
                "190198  1  0  0  0  0\n" +
                "192191  1  0  0  0  0\n" +
                "191195  1  0  0  0  0\n" +
                "191199  1  1  0  0  0\n" +
                "193192  1  0  0  0  0\n" +
                "192194  2  0  0  0  0\n" +
                "195196  1  0  0  0  0\n" +
                "196197  1  0  0  0  0\n" +
                "198197  1  0  0  0  0\n" +
                "205206  1  0  0  0  0\n" +
                "206207  1  0  0  0  0\n" +
                "206208  2  0  0  0  0\n" +
                "M  CHG  8   1   2  24  -1  33  -1  46  -1  95  -1  98   1  99   2 100   2\n" +
                "M  CHG  5 136  -1 145  -1 158  -1 207  -1 209   1\n" +
                "M  STY  4   1 MUL   2 MUL   3 MUL   4 MUL\n" +
                "M  SCN  1   1 HT \n" +
                "M  SAL   1  3   1  99 100\n" +
                "M  SPA   1  1   1\n" +
                "M  SDI   1  4   17.5142   -9.0844   17.5142   -8.2444\n" +
                "M  SDI   1  4   18.3542   -8.2444   18.3542   -9.0844\n" +
                "M  SMT   1 3\n" +
                "M  SCN  1   2 HT \n" +
                "M  SAL   2 14  97 101 102 103 104 105 106 107 108 109 110 111 112 113\n" +
                "M  SPA   2  1  97\n" +
                "M  SDI   2  4   18.4599   -2.4962   18.4599   -1.6562\n" +
                "M  SDI   2  4   19.2999   -1.6562   19.2999   -2.4962\n" +
                "M  SMT   2 14\n" +
                "M  SCN  1   3 HT \n" +
                "M  SAL   3 15   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16\n" +
                "M  SAL   3 15  17  18  19  20  21  22  23  24  25  26  27  28  29  30  31\n" +
                "M  SAL   3 15  32  33  34  35  36  37  38  39  40  41  42  43  44  45  46\n" +
                "M  SAL   3 15  47  48  49  50  51  52  53  54  55  56  57  58  59  60  61\n" +
                "M  SAL   3 15  62  63  64  65  66  67  68  69  70  71  72  73  74  75  76\n" +
                "M  SAL   3 15  77  78  79  80  81  82  83  84  85  86  87  88  89  90  91\n" +
                "M  SAL   3 15  92  93  94  95  96 114 115 116 117 118 119 120 121 122 123\n" +
                "M  SAL   3 15 124 125 126 127 128 129 130 131 132 133 134 135 136 137 138\n" +
                "M  SAL   3 15 139 140 141 142 143 144 145 146 147 148 149 150 151 152 153\n" +
                "M  SAL   3 15 154 155 156 157 158 159 160 161 162 163 164 165 166 167 168\n" +
                "M  SAL   3 15 169 170 171 172 173 174 175 176 177 178 179 180 181 182 183\n" +
                "M  SAL   3 15 184 185 186 187 188 189 190 191 192 193 194 195 196 197 198\n" +
                "M  SAL   3 10 199 200 201 202 203 204 205 206 207 208\n" +
                "M  SPA   3 15   2   3   4   5   6   7   8   9  10  11  12  13  14  15  16\n" +
                "M  SPA   3 15  17  18  19  20  21  22  23  24  25  26  27  28  29  30  31\n" +
                "M  SPA   3 15  32  33  34  35  36  37  38  39  40  41  42  43  44  45  46\n" +
                "M  SPA   3 15  47  48  49  50  51  52  53  54  55  56  57  58  59  60  61\n" +
                "M  SPA   3 15  62  63  64  65  66  67  68  69  70  71  72  73  74  75  76\n" +
                "M  SPA   3 15  77  78  79  80  81  82  83  84  85  86  87  88  89  90  91\n" +
                "M  SPA   3  5  92  93  94  95  96\n" +
                "M  SDI   3  4   -1.4695  -23.9544   -1.4695    2.5587\n" +
                "M  SDI   3  4   15.5710    2.5587   15.5710  -23.9544\n" +
                "M  SMT   3 2\n" +
                "M  SCN  1   4 HT \n" +
                "M  SAL   4  2  98 209\n" +
                "M  SPA   4  1  98\n" +
                "M  SDI   4  4   -5.0591   -7.6387   -5.0591   -6.7987\n" +
                "M  SDI   4  4   -4.2191   -6.7987   -4.2191   -7.6387\n" +
                "M  SMT   4 2\n" +
                "M  END";



        Chemical c = Chemical.parseMol(mol);
        assertEquals(4, c.getSGroupCount());
    }
}

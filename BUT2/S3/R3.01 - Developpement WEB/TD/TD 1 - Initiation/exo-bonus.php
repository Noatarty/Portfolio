<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>exo bonus</title>
</head>
<body>

    <style>
        *,
        ::before,
        ::after {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: 'Courier New', Courier, monospace;
        }

        table {
            table-layout: fixed;
            border-collapse: collapse;
        }

        tr:nth-child(even) {
            background-color: #000;
            color: #fff;
        }

        th, td {
            border: 2px solid #000;
            padding: 10px;
        }
        th {
            background-color: #fff;
            color: #000;
            font-size: 2rem;
            text-align: left;
            width: 500px;
        }
        td {
            width: 250px;
            font-weight: 600;
        }

        .num_dept {
            text-align: right;
        }
    </style>
    
    <?php 
        require_once('regions.php');
        require_once('depts-fix.php');

        arsort($regions);
    ?>

    <table>
        <?php 
            foreach ($regions as $nom_reg => $num_depts) {
        ?>
                <tr>
                    <th rowspan="<?php echo count($num_depts)?>"><?php echo $nom_reg;?></th>
                    <td><?php echo $depts[$num_depts[0]][0]?></td>
                    <td class="num_dept"><?php echo $num_depts[0];?></td>
                    <td><?php echo $depts[$num_depts[0]][1];?></td>
                </tr>
                <?php 
                    for ($i = 0; $i < count($num_depts) - 1; $i++) { 
                ?>
                        <tr>
                            <td><?php echo $depts[$num_depts[$i + 1]][0];?></td>
                            <td class="num_dept"><?php echo $num_depts[$i + 1];?></td>
                            <td><?php echo $depts[$num_depts[$i + 1]][1];?></td>
                        </tr>
                <?php 
                    }
                ?>
        <?php 
            }
        ?>
    </table>

</body>
</html>
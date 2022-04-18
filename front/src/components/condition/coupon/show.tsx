import React from 'react'
import Card from '@material-ui/core/Card'
import CardContent from '@material-ui/core/CardContent'
import Grid from '@material-ui/core/Grid'
import Typography from '@material-ui/core/Typography'
import {makeStyles} from '@material-ui/core/styles'
import {useShowController} from 'react-admin'
import CouponLimitsShow from './limits';

export const ConditionCouponShow = (props: any) => {
    const {record} = useShowController(props);
    const classes = useStyles();

    if (!record) return null;
    return (
        <Card className={classes.root}>
            <CardContent>
                <Grid container spacing={2}>
                    <Grid item xs={6}>
                        <Typography variant="h6" gutterBottom align="left" className={classes.mainColor}>
                            {record.name}
                        </Typography>

                    </Grid>
                    <Grid item xs={5}>
                        <Typography variant="h6" gutterBottom align="right">
                            ID: {record.id}
                        </Typography>
                    </Grid>
                </Grid>
                <hr/>
                {record.params.couponMinCoefficient && (
                    <div>
                        <b>Минимальный коэффициент купона:</b> {record.params.couponMinCoefficient}
                    </div>
                )}

                {record.params.couponStatus && (
                    <div>
                        <b>Статус купона:</b> {record.params.couponStatus}
                    </div>
                )}

                {record.params.couponType && (
                    <div>
                        <b>Тип купона:</b> {record.params.couponType}
                    </div>
                )}

                <div className={classes.limits}>
                    <CouponLimitsShow limits={record.params.limits}/>
                </div>
            </CardContent>
        </Card>
    )
}

export default ConditionCouponShow

const useStyles = makeStyles({
    root: {width: 800, margin: 'auto'},
    spacer: {height: 20},
    limits: {margin: '15px 0'},
    container: {minWidth: '35em', marginLeft: '0em'},
    mainColor: {color: '#283593'}

})